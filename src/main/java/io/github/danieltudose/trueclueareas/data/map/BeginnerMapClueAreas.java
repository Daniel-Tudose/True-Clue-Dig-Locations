package io.github.danieltudose.trueclueareas.data.map;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import java.util.Map;

public class BeginnerMapClueAreas {
    // Int IDs instead of WidgetID (deprecated) from WidgetID source:
    private static final int CHAMPIONS_GUILD    = 346;
    private static final int VARROCK_EAST_MINE  = 347;
    private static final int DRAYNOR            = 348;
    private static final int NORTH_OF_FALADOR   = 351;
    private static final int WIZARDS_TOWER      = 356;

    public static final Map<Integer, DigArea> AREAS = new ImmutableMap.Builder<Integer, DigArea>()
            .put(CHAMPIONS_GUILD,
                    new DigArea(new WorldPoint(3167, 3360, 0), 3))
            .put(VARROCK_EAST_MINE,
                    new DigArea(new WorldPoint(3290, 3373, 0), 3))
            .put(DRAYNOR,
                    new DigArea(new WorldPoint(3092, 3226, 0), 3))
            .put(NORTH_OF_FALADOR,
                    new DigArea(new WorldPoint(3043, 3399, 0), 3))
            .put(WIZARDS_TOWER,
                    new DigArea(new WorldPoint(3109, 3153, 0), 3))
            .build();
}