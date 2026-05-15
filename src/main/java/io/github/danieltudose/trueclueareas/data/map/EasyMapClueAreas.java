package io.github.danieltudose.trueclueareas.data.map;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;

import java.util.Map;

public class EasyMapClueAreas {
    private static final int CHAMPIONS_GUILD = ItemID.TRAIL_CLUE_EASY_MAP001;
    private static final int VARROCK_EAST_MINE = ItemID.TRAIL_CLUE_EASY_MAP002;
    private static final int NORTH_OF_FALADOR = ItemID.TRAIL_CLUE_EASY_MAP003;
    private static final int WIZARDS_TOWER = ItemID.TRAIL_CLUE_EASY_MAP005;


    public static final Map<Integer, DigArea> AREAS = new ImmutableMap.Builder<Integer, DigArea>()
            .put(CHAMPIONS_GUILD,
                    new DigArea(new WorldPoint(3167, 3360, 0), 3))
            .put(VARROCK_EAST_MINE,
                    new DigArea(new WorldPoint(3290, 3373, 0), 3))
            .put(NORTH_OF_FALADOR,
                    new DigArea(new WorldPoint(3043, 3399, 0), 3))
            .put(WIZARDS_TOWER,
                    new DigArea(new WorldPoint(3109, 3153, 0), 3))
            .build();
}