package io.github.danieltudose.trueclueareas.data.map;

import io.github.danieltudose.trueclueareas.data.DigArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;

import java.util.*;

public class CustomMapClueAreas {

    public static final Set<Integer> ELITE_MAP_CLUE_IDS = Set.of(
            ItemID.TRAIL_ELITE_MAP_EXP1,
            ItemID.TRAIL_ELITE_MAP_EXP2,
            ItemID.TRAIL_ELITE_MAP_EXP3,
            ItemID.TRAIL_ELITE_MAP_EXP4,
            ItemID.TRAIL_ELITE_MAP_EXP5,
            ItemID.TRAIL_ELITE_MAP_EXP6
    );

    public static final Map<WorldPoint, DigArea> MAP_STEPS_CUSTOM_AREAS;
    static {
        Map<WorldPoint, DigArea> m = new HashMap<>();
        //Insert here new entries;
        MAP_STEPS_CUSTOM_AREAS = Collections.unmodifiableMap(m);
    }
}