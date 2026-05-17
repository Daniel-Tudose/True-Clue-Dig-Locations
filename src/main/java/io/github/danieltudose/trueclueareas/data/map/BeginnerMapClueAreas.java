package io.github.danieltudose.trueclueareas.data.map;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.InterfaceID;

import java.util.Map;

public class BeginnerMapClueAreas {
    public static final Map<Integer, DigArea> AREAS = new ImmutableMap.Builder<Integer, DigArea>()
            .put(InterfaceID.TRAIL_MAP01, // 346 = champion's guild
                    new DigArea(new WorldPoint(3167, 3360, 0), 3))
            .put(InterfaceID.TRAIL_MAP02, // 347 = varrock east mine
                    new DigArea(new WorldPoint(3290, 3373, 0), 3))
            .put(InterfaceID.TRAIL_MAP03, // 348 = south of draynor bank
                    new DigArea(new WorldPoint(3092, 3226, 0), 3))
            .put(InterfaceID.TRAIL_MAP06, // 351 = standing stones north of falador
                    new DigArea(new WorldPoint(3043, 3399, 0), 3))
            .put(InterfaceID.TRAIL_MAP11, // 356 = south of wizard's tower
                    new DigArea(new WorldPoint(3109, 3153, 0), 3))
            .build();
}