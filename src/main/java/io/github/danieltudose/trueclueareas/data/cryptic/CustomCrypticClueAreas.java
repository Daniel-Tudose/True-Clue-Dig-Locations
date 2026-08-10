package io.github.danieltudose.trueclueareas.data.cryptic;

import io.github.danieltudose.trueclueareas.data.DigArea;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;

import java.util.*;

public class CustomCrypticClueAreas {

    // Elite clues are single tile (base plugin already highlights them).
    public static final Set<Integer> SKIP_CRYPTIC_CLUE_IDS = Set.of(
            //ItemID.TRAIL_ELITE_RIDDLE_EXP7, //This is most likely a 3x3 area (or a 7x7 area for master tier steps)  instead of the usual single tile highlighted by runelite's base clue plugin
            //ItemID.TRAIL_ELITE_RIDDLE_EXP11, //This is bigger than a single tile (a 3x3?) - (elite cryptic step that says "Dig in front of the Law rift in the abyss")
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
        m.put(new WorldPoint(1753, 4936, 0),  new DigArea(new WorldPoint(1759, 4942, 0), 7)); // Terrorbird Display - Master
        m.put(new WorldPoint(2591, 3879, 0),  new DigArea(new WorldPoint(2592, 3879, 0), 3)); // Evergreen in Etceteria - Hard
        m.put(new WorldPoint(3195, 3357, 0),  new DigArea(new WorldPoint(3195, 3353, 0), new WorldPoint(3198, 3358, 0))); // Champion's Guild chicken coop - Hard
        m.put(new WorldPoint(1820, 9935, 0),  new DigArea(new WorldPoint(1818, 9933, 0), new WorldPoint(1822, 9936, 0))); // Forthos Dungeon - Hard
        m.put(new WorldPoint(3388, 3152, 0),  new DigArea(new WorldPoint(3386, 3150, 0), new WorldPoint(3389, 3153, 0))); // Clan Cup Trophy SW of the Citharede Abbey - Hard
        m.put(new WorldPoint(3572, 4372, 0),  new DigArea(new WorldPoint(3572, 4372, 0), 10)); // Yu'biusk (fairy ring BLQ) - Hard
        m.put(new WorldPoint(3089, 3468, 0),  new DigArea(new WorldPoint(3088, 3469, 0), 3)); // Edgeville - R of the S yew tree - Hard
        m.put(new WorldPoint(1910, 4367, 0),  new DigArea(new WorldPoint(1911, 4367, 0), 3)); // Dagganoth ladder - Elite
        m.put(new WorldPoint(1179, 3626, 0),  new DigArea(new WorldPoint(1172, 3621, 0), new WorldPoint(1183, 3633, 0))); // Fire beside Ket'sal K'uk (Kebos Swamp) - Hard
        m.put(new WorldPoint(3488, 3289, 0),  new DigArea(new WorldPoint(3486, 2385, 0), new WorldPoint(3490, 3289, 0))); // Road intersection in Mort'ton - Hard
        CRYPTIC_STEPS_CUSTOM_AREAS = Collections.unmodifiableMap(m);
    }
}