package io.github.danieltudose.trueclueareas;

import io.github.danieltudose.trueclueareas.data.emote.BeginnerEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.EasyEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.MediumEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.HardEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.EliteEmoteClueAreas;
import io.github.danieltudose.trueclueareas.data.emote.MasterEmoteClueAreas;

import java.util.*;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.gameval.*;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginManager;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import net.runelite.client.plugins.cluescrolls.clues.*;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdLocation;
import net.runelite.client.ui.overlay.OverlayManager;

import javax.inject.Inject;

import static net.runelite.client.plugins.cluescrolls.clues.Enemy.*;

@Slf4j
@PluginDescriptor(
		name = "True Clue Areas",
		description = "Highlights the true dig/emote areas for clue scroll steps",
		tags = {"clue", "scroll", "overlay", "dig", "area", "emote", "clues"})

public class TrueClueAreasPlugin extends Plugin {
	@Inject private net.runelite.client.callback.ClientThread clientThread;
	@Inject private Client client;
	@Inject private TrueClueAreasConfig config;
	@Inject private OverlayManager overlayManager;
	@Inject private TrueClueAreasOverlay overlay;
	@Inject private PluginManager pluginManager;

	private static final Map<String, DigArea> ALL_EMOTE_AREAS;
	private ClueScroll lastKnownClue = null;

	private static final Map<WorldPoint, DigArea> CRYPTIC_CUSTOM_AREAS;
	static {
		Map<WorldPoint, DigArea> m = new HashMap<>();
		// Key = base plugin's stored WorldPoint for that clue
		// Value = the actual dig area with correct SW/NE corners or center tile with width/height
		m.put(new WorldPoint(2857, 2966, 0),	new DigArea(new WorldPoint(2857, 2965, 0), 7)); //Shilo Village furnace
		m.put(new WorldPoint(2927, 3761, 0),	new DigArea(new WorldPoint(2927, 3763, 0), 7)); //by the large crossbow from GWD entrance
		m.put(new WorldPoint(3303, 6092, 0),	new DigArea(new WorldPoint(3303, 6091, 0), 7)); //Priff onion patch
		m.put(new WorldPoint(2410, 4714, 0),	new DigArea(new WorldPoint(2409, 4715, 0), 7)); //Viyeldi caves
		m.put(new WorldPoint(3045, 10265, 0),new DigArea(new WorldPoint(3046, 10265, 0), 7)); //runite rock in Lava Maze Dungeon
		m.put(new WorldPoint(2744, 5116, 0),	new DigArea(new WorldPoint(2745, 5115, 0), 7)); //Shadow Dungeon
		m.put(new WorldPoint(3043, 4974, 1),	new DigArea(new WorldPoint(3043, 4973, 1), 7)); //fire in the Rogues' Den
		CRYPTIC_CUSTOM_AREAS = Collections.unmodifiableMap(m);
	}

	private static final Set<Integer> ELITE_MAP_CLUE_IDS = Set.of(
			ItemID.TRAIL_ELITE_MAP_EXP1,
			ItemID.TRAIL_ELITE_MAP_EXP2,
			ItemID.TRAIL_ELITE_MAP_EXP3,
			ItemID.TRAIL_ELITE_MAP_EXP4,
			ItemID.TRAIL_ELITE_MAP_EXP5,
			ItemID.TRAIL_ELITE_MAP_EXP6
	);

	private static final Set<Integer> ELITE_CRYPTIC_CLUE_IDS = Set.of(
			ItemID.TRAIL_ELITE_RIDDLE_EXP7,
			ItemID.TRAIL_ELITE_RIDDLE_EXP11,
			ItemID.TRAIL_ELITE_RIDDLE_EXP9,
			ItemID.TRAIL_ELITE_RIDDLE_EXP34,
			ItemID.TRAIL_ELITE_RIDDLE_EXP35,
			ItemID.TRAIL_ELITE_RIDDLE_EXP3,
			ItemID.TRAIL_ELITE_RIDDLE_EXP19,
			ItemID.TRAIL_ELITE_RIDDLE_EXP4,
			ItemID.TRAIL_ELITE_RIDDLE_EXP37,
			ItemID.TRAIL_ELITE_RIDDLE_EXP38,
			ItemID.TRAIL_ELITE_RIDDLE_EXP39,
			ItemID.TRAIL_ELITE_RIDDLE_EXP2
			);

	static {
		Map<String, DigArea> emoteAreas = new HashMap<>();
		emoteAreas.putAll(BeginnerEmoteClueAreas.AREAS);
		emoteAreas.putAll(EasyEmoteClueAreas.AREAS);
		emoteAreas.putAll(MediumEmoteClueAreas.AREAS);
		emoteAreas.putAll(HardEmoteClueAreas.AREAS);
		emoteAreas.putAll(EliteEmoteClueAreas.AREAS);
		emoteAreas.putAll(MasterEmoteClueAreas.AREAS);
		ALL_EMOTE_AREAS = Collections.unmodifiableMap(emoteAreas);
	}

	private void clearAll() {
		overlay.clearDigArea();
		overlay.setHotColdLocations(null);
		lastKnownClue = null;
	}

	@Override
	protected void startUp() {
		overlayManager.add(overlay);
	}

	@Override
	protected void shutDown() {
		overlayManager.remove(overlay);
		clearAll();
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event) {
		switch (event.getGroupId()) {
			case 203: // Standard Text Clue Interface
				handleTextClue();
				break;
			case 231: // NPC Dialog (Uri)
				handleUriDialog();
				break;
			case 193: // Sprite Dialog (Clue Step Finished)
				handleClueFinished();
				break;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event) {
		ClueScrollPlugin cluePlugin = getClueScrollPlugin();
		ClueScroll current = cluePlugin != null ? cluePlugin.getClue() : null;

		if (current != lastKnownClue) {
			lastKnownClue = current;
			onClueChanged(current, cluePlugin);
		}

		if (current instanceof HotColdClue) {
			updateHotColdFromBasePlugin((HotColdClue) current, cluePlugin);
		} else {
			overlay.setHotColdLocations(null);
		}
	}

	private void onClueChanged(ClueScroll newClue, ClueScrollPlugin cluePlugin) {
		if (newClue == null) {
			clearAll();
			return;
		}

		if (newClue instanceof MapClue) {
			MapClue mapClue = (MapClue) newClue;
			if (ELITE_MAP_CLUE_IDS.contains(mapClue.getItemId())) return;
			WorldPoint loc = mapClue.getLocation(cluePlugin);
			if (loc != null) {
				overlay.setDigArea(new DigArea(loc, 3), TrueClueAreasOverlay.ClueType.MAP);
			}
			return;
		}

		if (newClue instanceof CrypticClue) {
			CrypticClue crypticClue = (CrypticClue) newClue;
			if (crypticClue.getItemIds().stream().anyMatch(ELITE_CRYPTIC_CLUE_IDS::contains)) return;
			if (crypticClue.isRequiresSpade()) {
				WorldPoint loc = crypticClue.getLocation(cluePlugin);
				if (loc == null) return;

				DigArea customArea = CRYPTIC_CUSTOM_AREAS.get(loc);
				if (customArea != null) {
					overlay.setDigArea(customArea, TrueClueAreasOverlay.ClueType.MAP);
					return;
				}

				boolean isMaster = crypticClue.getItemIds().contains(ItemID.TRAIL_CLUE_MASTER);
				overlay.setDigArea(new DigArea(loc, isMaster ? 7 : 3), TrueClueAreasOverlay.ClueType.MAP);
				return;
			}
		}

		if (newClue instanceof CoordinateClue) {
			CoordinateClue coordClue = (CoordinateClue) newClue;
			// Skip Elite coordinate clues to avoid a redundant overlay since they are just 1 tile
			if (coordClue.getEnemy() == ARMADYLEAN_OR_BANDOSIAN_GUARD
					|| coordClue.getEnemy() == ARMADYLEAN_GUARD
					|| coordClue.getEnemy() == BANDOSIAN_GUARD) {
				return;
			}
			WorldPoint loc = coordClue.getLocation(cluePlugin);
			if (loc != null) {
				overlay.setDigArea(new DigArea(loc, 3), TrueClueAreasOverlay.ClueType.COORDINATE);
			}
		}
	}

	private void updateHotColdFromBasePlugin(HotColdClue hotColdClue, ClueScrollPlugin cluePlugin) {
		WorldPoint[] locations = hotColdClue.getLocations(cluePlugin);

		Set<HotColdLocation> matched = new HashSet<>();
		for (WorldPoint wp : locations) {
			for (HotColdLocation loc : HotColdLocation.values()) {
				if (loc.getWorldPoint().equals(wp)) {
					matched.add(loc);
					break;
				}
			}
		}

		if (!matched.isEmpty() && matched.size() <= config.hotColdThreshold()) {
			overlay.setHotColdLocations(matched);
		} else {
			overlay.setHotColdLocations(null);
		}
	}

	private ClueScrollPlugin getClueScrollPlugin() {
		return pluginManager.getPlugins().stream()
				.filter(p -> p instanceof ClueScrollPlugin)
				.map(p -> (ClueScrollPlugin) p)
				.findFirst()
				.orElse(null);
	}

	private void handleTextClue() {
		clearAll();
		clientThread.invokeLater(() -> {
			net.runelite.api.widgets.Widget clueWidget = client.getWidget(203, 2);
			if (clueWidget == null || clueWidget.getText() == null || clueWidget.getText().isEmpty()) return;

			String text = clueWidget.getText()
					.replaceAll("(?i)<br\\s*/?>", " ")
					.replaceAll("<[^>]*>", "")
					.replaceAll("\\s+", " ")
					.trim();
			DigArea emoteArea = ALL_EMOTE_AREAS.get(text);
			if (emoteArea != null) {
				overlay.setDigArea(emoteArea, TrueClueAreasOverlay.ClueType.EMOTE);
			}
		});
	}

	private void handleUriDialog() {
		clientThread.invokeLater(() -> {
			net.runelite.api.widgets.Widget nameWidget = client.getWidget(231, 4);
			if (nameWidget != null && "Uri".equals(nameWidget.getText())) {
				clearAll();
			}
		});
	}

	private void handleClueFinished() {
		clientThread.invokeLater(() -> {
			net.runelite.api.widgets.Widget textWidget = client.getWidget(193, 2);
			if (textWidget != null && (textWidget.getText().contains("casket") || textWidget.getText().contains("new clue"))) {
				clearAll();
			}
		});
	}

	@Subscribe
	public void onGameStateChanged(net.runelite.api.events.GameStateChanged event) {
		if (event.getGameState() == GameState.LOGIN_SCREEN) {
			clearAll();
		}
	}

	@Provides
	TrueClueAreasConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(TrueClueAreasConfig.class);
	}
}