package io.github.danieltudose.trueclueareas.data.map;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;

import java.util.Map;

public class EliteMapClueAreas {
    public static final Map<Integer, DigArea> AREAS = new ImmutableMap.Builder<Integer, DigArea>()
            .put(ItemID.TRAIL_ELITE_MAP_EXP1, // North east of Castle Wars, just west of fairy ring CIQ
                    new DigArea(new WorldPoint(2447, 3108, 0), new WorldPoint(2455, 3116, 0)))
            .build();
}