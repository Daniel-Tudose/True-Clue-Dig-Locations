package io.github.danieltudose.trueclueareas.data.map;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;

import java.util.Map;

public class EasyMapClueAreas {
    public static final Map<Integer, DigArea> AREAS = new ImmutableMap.Builder<Integer, DigArea>()
            .put(ItemID.TRAIL_CLUE_EASY_MAP001, // 2713 = champion's guild
                    new DigArea(new WorldPoint(3167, 3360, 0), 3))
            .put(ItemID.TRAIL_CLUE_EASY_MAP002, // 2716 = south-east mine of varrock
                    new DigArea(new WorldPoint(3290, 3373, 0), 3))
            .put(ItemID.TRAIL_CLUE_EASY_MAP003, // 2719 = standing stones north of falador
                    new DigArea(new WorldPoint(3043, 3399, 0), 3))
            .put(ItemID.TRAIL_CLUE_EASY_MAP005, // 3518 = south of wizard's tower
                    new DigArea(new WorldPoint(3109, 3153, 0), 3))
            .build();
}