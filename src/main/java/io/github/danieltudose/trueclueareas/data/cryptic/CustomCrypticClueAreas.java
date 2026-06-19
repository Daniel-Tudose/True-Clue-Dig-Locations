package io.github.danieltudose.trueclueareas.data.cryptic;

import io.github.danieltudose.trueclueareas.data.DigArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;

import java.util.*;

public class CustomCrypticClueAreas {

    // Elite clues are single tile (base plugin already highlights them).
    public static final Set<Integer> SKIP_CRYPTIC_CLUE_IDS = Set.of(
            //ItemID.TRAIL_ELITE_RIDDLE_EXP7, //This is most likely a 3x3 area instead of the usual single tile highlighted by runelite's base clue plugin
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
            // add single-tile any tier clue item IDs here as discovered
    );

    public static final Map<WorldPoint, DigArea> CRYPTIC_STEPS_CUSTOM_AREAS;
    static {
        Map<WorldPoint, DigArea> m = new HashMap<>();
        m.put(new WorldPoint(2857, 2966, 0),  new DigArea(new WorldPoint(2857, 2965, 0), 7)); // Shilo Village furnace - Master
        m.put(new WorldPoint(2927, 3761, 0),  new DigArea(new WorldPoint(2927, 3763, 0), 7)); // By the large crossbow from GWD entrance - Master
        m.put(new WorldPoint(3303, 6092, 0),  new DigArea(new WorldPoint(3303, 6091, 0), 7)); // Priff onion patch - Master
        m.put(new WorldPoint(2410, 4714, 0),  new DigArea(new WorldPoint(2409, 4715, 0), 7)); // Viyeldi caves - Master
        m.put(new WorldPoint(3045, 10265, 0), new DigArea(new WorldPoint(3046, 10265, 0), 7)); // Runite rock in Lava Maze Dungeon - Master
        m.put(new WorldPoint(2744, 5116, 0),  new DigArea(new WorldPoint(2745, 5115, 0), 7)); // Shadow Dungeon - Master
        m.put(new WorldPoint(3043, 4974, 1),  new DigArea(new WorldPoint(3043, 4973, 1), 7)); // Fire in the Rogues' Den - Master
        m.put(new WorldPoint(2874, 3757, 0),  new DigArea(new WorldPoint(2877, 3757, 0), 7)); // North of Trollheim - Master
        m.put(new WorldPoint(2591, 3879, 0),  new DigArea(new WorldPoint(2592, 3879, 0), 3)); // Evergreen in Etceteria - Hard
        CRYPTIC_STEPS_CUSTOM_AREAS = Collections.unmodifiableMap(m);
    }
}