package com.example;

import com.example.data.emote.BeginnerEmoteClueAreas;
import com.example.data.map.BeginnerMapClueAreas;
import com.example.data.DigArea;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdLocation;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdSolver;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdTemperature;
import net.runelite.client.ui.overlay.OverlayManager;
import net.runelite.api.events.GameTick;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;

@Slf4j
@PluginDescriptor(
		name = "True Clue Areas",
		description = "Highlights the true dig/emote areas for clue scroll steps",
		tags = {"clue", "scroll", "overlay", "dig", "area", "emote", "clues"})
public class TrueClueAreasPlugin extends Plugin {
	@Inject
	private net.runelite.client.callback.ClientThread clientThread;

	@Inject
	private Client client;

	@Inject
	private TrueClueAreasConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private TrueClueAreasOverlay overlay;

	private HotColdSolver hotColdSolver = null;
	private int ticksSinceAreaSet = 0;
	private static final int HINT_ARROW_CHECK_DELAY = 3;

	private void clearAll()	{
		overlay.setDigArea(null);
		overlay.setHotColdLocations(null);
		hotColdSolver = null;
		ticksSinceAreaSet = 0;
		log.debug("Overlay cleared");
	}

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() throws Exception {
		overlayManager.remove(overlay);
		clearAll();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		log.debug("Widget loaded: groupId={}", event.getGroupId());
		// Map clues
		DigArea mapArea = BeginnerMapClueAreas.AREAS.get(event.getGroupId());
		if (mapArea != null)
		{
			overlay.setDigArea(mapArea, TrueClueAreasOverlay.ClueType.MAP);
			overlay.setHotColdLocations(null);
			ticksSinceAreaSet = 0;
			log.debug("Map clue detected");
			return;
		}

		// Emote and other text-based clues — read the widget text
		// Group ID 203 is the clue scroll interface (CLUE_SCROLL_GROUP_ID)
		if (event.getGroupId() != 203) return;

		clientThread.invokeLater(() ->
		{
			net.runelite.api.widgets.Widget clueWidget = client.getWidget(203, 2);
			if (clueWidget == null || clueWidget.getText() == null
					|| clueWidget.getText().isEmpty()) return false;

			String text = clueWidget.getText()
					.replaceAll("<[^>]*>", "")
					.trim();

			log.debug("Clue scroll text: '{}'", text);

			DigArea emoteArea = BeginnerEmoteClueAreas.AREAS.get(text);
			if (emoteArea != null)
			{
				overlay.setDigArea(emoteArea, TrueClueAreasOverlay.ClueType.EMOTE);
				overlay.setHotColdLocations(null);
				ticksSinceAreaSet = 0;
				log.debug("Emote clue detected: {}", text);
			}

			return true;
		});
	}
	private void scanWidget(net.runelite.api.widgets.Widget widget, int depth)
	{
		if (widget == null) return;

		String text = widget.getText();
		if (text != null && !text.isEmpty())
		{
			log.debug("{}Widget id={} text='{}'",
					"  ".repeat(depth),
					widget.getId(),
					text);
		}

		// Scan direct children
		net.runelite.api.widgets.Widget[] children = widget.getChildren();
		if (children != null)
		{
			for (net.runelite.api.widgets.Widget child : children)
			{
				scanWidget(child, depth + 1);
			}
		}

		// Scan dynamic children
		net.runelite.api.widgets.Widget[] dynamicChildren = widget.getDynamicChildren();
		if (dynamicChildren != null)
		{
			for (net.runelite.api.widgets.Widget child : dynamicChildren)
			{
				scanWidget(child, depth + 1);
			}
		}

		// Scan nested children
		net.runelite.api.widgets.Widget[] nestedChildren = widget.getNestedChildren();
		if (nestedChildren != null)
		{
			for (net.runelite.api.widgets.Widget child : nestedChildren)
			{
				scanWidget(child, depth + 1);
			}
		}
	}
	@Subscribe
	public void onGameTick(GameTick event) {
		net.runelite.api.widgets.Widget clueWidget = client.getWidget(203, 2);
		if (clueWidget != null && !clueWidget.getText().isEmpty())
		{
			String text = clueWidget.getText()
					.replaceAll("<[^>]*>", "")
					.trim();
			log.debug("Clue widget text: '{}'", text);
		}		if (!overlay.hasActiveArea()) return;

		ticksSinceAreaSet++;
		if (ticksSinceAreaSet < HINT_ARROW_CHECK_DELAY) return;

		if (client.getHintArrowPoint() == null && client.getHintArrowNpc() == null) {
			clearAll();
		}
	}

	@Subscribe
	public void onChatMessage(ChatMessage event) {
		if (event.getType() != ChatMessageType.GAMEMESSAGE) {
			return;
		}

		String message = event.getMessage().replaceAll("<[^>]*>", "").trim();

		DigArea emoteArea = BeginnerEmoteClueAreas.AREAS.get(message);
		if (emoteArea != null) {
			overlay.setDigArea(emoteArea, TrueClueAreasOverlay.ClueType.EMOTE);
			overlay.setHotColdLocations(null);
			ticksSinceAreaSet = 0;
			log.debug("Emote clue detected");
			return;
		}

		HotColdTemperature temperature = HotColdTemperature.getFromTemperatureSet(
				HotColdTemperature.BEGINNER_HOT_COLD_TEMPERATURES, message);

		if (temperature != null) {
			if (hotColdSolver == null) {
				Set<HotColdLocation> beginnerLocations = new HashSet<>();
				for (HotColdLocation loc : HotColdLocation.values()) {
					if (loc.isBeginnerClue()) {
						beginnerLocations.add(loc);
					}
				}
				hotColdSolver = new HotColdSolver(beginnerLocations);
			}

			WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
			hotColdSolver.signal(playerLocation, temperature, null);

			int remaining = hotColdSolver.getPossibleLocations().size();
			log.debug("Hot/cold: {} — {} locations remain", temperature, remaining);

			if (remaining <= config.hotColdThreshold() && remaining > 0) {
				overlay.setHotColdLocations(hotColdSolver.getPossibleLocations());
				overlay.setDigArea(null);
				ticksSinceAreaSet = 0;
			}
			else {
				overlay.setHotColdLocations(null);
			}
		}
	}

	@Provides
	TrueClueAreasConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(TrueClueAreasConfig.class);
	}
}