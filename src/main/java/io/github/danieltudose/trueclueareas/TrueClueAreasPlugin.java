package io.github.danieltudose.trueclueareas;

import io.github.danieltudose.trueclueareas.data.emote.BeginnerEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.map.BeginnerMapClueAreas;
import io.github.danieltudose.trueclueareas.data.map.EasyMapClueAreas;
import io.github.danieltudose.trueclueareas.data.map.MediumMapClueAreas;
import io.github.danieltudose.trueclueareas.data.map.HardMapClueAreas;
import io.github.danieltudose.trueclueareas.data.map.EliteMapClueAreas;
import io.github.danieltudose.trueclueareas.data.map.MasterMapClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.EasyEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.MediumEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.HardEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.EliteEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.MasterEmoteClueAreas;

import java.util.*;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.ChatMessage;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdLocation;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdSolver;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdTemperature;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;


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

	private static final Map<Integer, DigArea> ALL_MAP_AREAS;
	private static final Map<String, DigArea> ALL_EMOTE_AREAS;

	static {
		Map<Integer, DigArea> mapAreas = new HashMap<>();
		mapAreas.putAll(BeginnerMapClueAreas.AREAS);
		mapAreas.putAll(EasyMapClueAreas.AREAS);
		mapAreas.putAll(MediumMapClueAreas.AREAS);
		mapAreas.putAll(HardMapClueAreas.AREAS);
		mapAreas.putAll(EliteMapClueAreas.AREAS);
		mapAreas.putAll(MasterMapClueAreas.AREAS);
		ALL_MAP_AREAS = Collections.unmodifiableMap(mapAreas);

		Map<String, DigArea> emoteAreas = new HashMap<>();
		emoteAreas.putAll(BeginnerEmoteClueAreas.AREAS);
		emoteAreas.putAll(EasyEmoteClueAreas.AREAS);
		emoteAreas.putAll(MediumEmoteClueAreas.AREAS);
		emoteAreas.putAll(HardEmoteClueAreas.AREAS);
		emoteAreas.putAll(EliteEmoteClueAreas.AREAS);
		emoteAreas.putAll(MasterEmoteClueAreas.AREAS);
		ALL_EMOTE_AREAS = Collections.unmodifiableMap(emoteAreas);
	}

	private void clearAll()	{
		overlay.setDigArea(null);
		overlay.setHotColdLocations(null);
		hotColdSolver = null;

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
		// Map clues — detected by widget group ID (the map image interface)
		DigArea mapArea = ALL_MAP_AREAS.get(event.getGroupId());
		if (mapArea != null)
		{
			overlay.setHotColdLocations(null);
			hotColdSolver = null;
			overlay.setDigArea(mapArea, TrueClueAreasOverlay.ClueType.MAP);
			return;
		}

		// Text clue interface (emote, cryptic, NPC steps etc.)
		if (event.getGroupId() != 203) return;

		// Always clear when a new text step loads
		overlay.setDigArea(null);
		overlay.setHotColdLocations(null);
		hotColdSolver = null;

		clientThread.invokeLater(() -> {
			net.runelite.api.widgets.Widget clueWidget = client.getWidget(203, 2);
			if (clueWidget == null || clueWidget.getText() == null
					|| clueWidget.getText().isEmpty()) return false;

			String text = clueWidget.getText()
					.replaceAll("<[^>]*>", "")
					.trim();

			// Only emote clues here — map clues have their own widget group
			DigArea emoteArea = ALL_EMOTE_AREAS.get(text);
			if (emoteArea != null)
			{
				overlay.setDigArea(emoteArea, TrueClueAreasOverlay.ClueType.EMOTE);
			}
			// If no match found, overlay stays cleared (NPC step, cryptic etc.)

			return true;
		});
	}
	private boolean isMasterHotCold() {
		ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
		if (inventory == null) return false;
		for (Item item : inventory.getItems()) {
			if (item.getId() == ItemID.CLUE_SCROLL_MASTER) return true;
		}
		return false;
	}

	@Subscribe
	public void onItemContainerChanged(ItemContainerChanged event)
	{
		if (event.getContainerId() != InventoryID.INVENTORY.getId()) return;
		if (!overlay.hasActiveArea()) return;

		for (Item item : event.getItemContainer().getItems())
		{
			int id = item.getId();
			if (id == ItemID.CLUE_SCROLL_BEGINNER
					|| id == ItemID.CLUE_SCROLL_EASY
					|| id == ItemID.CLUE_SCROLL_MEDIUM
					|| id == ItemID.CLUE_SCROLL_HARD
					|| id == ItemID.CLUE_SCROLL_ELITE
					|| id == ItemID.CLUE_SCROLL_MASTER)
			{
				return; // still has clue
			}
		}

		clearAll();
	}

	@Subscribe
	public void onChatMessage(ChatMessage event) {
		if (event.getType() != ChatMessageType.GAMEMESSAGE) {
			return;
		}

		String message = event.getMessage().replaceAll("<[^>]*>", "").trim();

		boolean isMaster = isMasterHotCold();
		HotColdTemperature temperature = HotColdTemperature.getFromTemperatureSet(
				isMaster ? HotColdTemperature.MASTER_HOT_COLD_TEMPERATURES
						: HotColdTemperature.BEGINNER_HOT_COLD_TEMPERATURES,
				message);

		if (temperature != null) {
			if (hotColdSolver == null) {
				Set<HotColdLocation> locations = new HashSet<>();
				for (HotColdLocation loc : HotColdLocation.values()) {
					if (loc.isBeginnerClue() != isMaster) {
						locations.add(loc);
					}
				}
				hotColdSolver = new HotColdSolver(locations);
			}

			WorldPoint playerLocation = client.getLocalPlayer().getWorldLocation();
			hotColdSolver.signal(playerLocation, temperature, null);

			int remaining = hotColdSolver.getPossibleLocations().size();

			if (remaining <= config.hotColdThreshold() && remaining > 0) {
				overlay.setHotColdLocations(hotColdSolver.getPossibleLocations());
				overlay.setDigArea(null);
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