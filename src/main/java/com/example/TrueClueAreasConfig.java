package com.example;

import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

import java.awt.Color;

@ConfigGroup("trueclue")
public interface TrueClueAreasConfig extends Config {
	@ConfigSection(
			name = "Map Clues",
			description = "Settings for map clue step highlights",
			position = 0)
	String mapSection = "mapClues";

	@ConfigSection(
			name = "Emote Clues",
			description = "Settings for emote clue step highlights",
			position = 1)
	String emoteSection = "emoteClues";

	@ConfigSection(
			name = "Hot/Cold Clues",
			description = "Settings for hot/cold clue step highlights",
			position = 2)
	String hotColdSection = "hotColdClues";

	@ConfigItem(
			keyName = "showMapClues",
			name = "Show map clue areas",
			description = "Highlight the dig area for map clue steps",
			section = mapSection,
			position = 0)
	default boolean showMapClues() {
		return true;
	}

	@Alpha
	@ConfigItem(
			keyName = "mapClueColor",
			name = "Highlight color",
			description = "Color of the map clue dig area highlight",
			section = mapSection,
			position = 1)
	default Color mapClueColor() {
		return new Color(255, 165, 0, 50); // orange, semi-transparent
	}

	@ConfigItem(
			keyName = "showEmoteClues",
			name = "Show emote clue areas",
			description = "Highlight the area for emote clue steps",
			section = emoteSection,
			position = 0)
	default boolean showEmoteClues() {
		return true;
	}

	@Alpha
	@ConfigItem(
			keyName = "emoteClueColor",
			name = "Highlight color",
			description = "Color of the emote clue area highlight",
			section = emoteSection,
			position = 1)
	default Color emoteClueColor() {
		return new Color(255, 165, 0, 50); // orange, semi-transparent
	}

	@ConfigItem(
			keyName = "showHotColdClues",
			name = "Show hot/cold areas",
			description = "Highlight possible dig areas for hot/cold clue steps",
			section = hotColdSection,
			position = 0)
	default boolean showHotColdClues() {
		return true;
	}

	@Alpha
	@ConfigItem(
			keyName = "hotColdColor",
			name = "Highlight color",
			description = "Color of the hot/cold area highlight",
			section = hotColdSection,
			position = 1)
	default Color hotColdColor() {
		return new Color(255, 0, 0, 50); // red, semi-transparent
	}

	@Range(min = 1, max = 5)
	@ConfigItem(
			keyName = "hotColdThreshold",
			name = "Show overlay when X locations remain",
			description = "Only show the hot/cold overlay when this many or fewer locations remain",
			section = hotColdSection,
			position = 2)
	default int hotColdThreshold() {
		return 2;
	}
}