package com.example.data.emote;

import com.example.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;

import java.util.Map;

public class BeginnerEmoteClueAreas {
    public static final Map<String, DigArea> AREAS = new ImmutableMap.Builder<String, DigArea>()
            .put("Blow a raspberry at Aris in her tent. Equip a gold ring and a gold necklace.",
                    new DigArea(new WorldPoint(3203, 3424, 0), 5))
            .put("Bow to Brugsen Bursen at the Grand Exchange.",
                    new DigArea(new WorldPoint(3165, 3477, 0), 5))
            .put("Cheer at Iffie Nitter. Equip a chef hat and a red cape.",
                    new DigArea(new WorldPoint(3202, 3414, 0), new WorldPoint(3208,3419,0)))
            .put("Clap at Bob's Brilliant Axes. Equip a bronze axe and leather boots.",
                    new DigArea(new WorldPoint(3231, 3203, 0), 3))
            .put("Panic at Al Kharid mine.",
                    new DigArea(new WorldPoint(3285, 3271, 0), new WorldPoint(3314,3318,0)))
            .put("Spin at Flynn's Mace Shop.",
                    new DigArea(new WorldPoint(2948, 3385, 0),new WorldPoint(2952, 3390,0)))
            .build();
}