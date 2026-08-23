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
        m.put(new WorldPoint(2615, 3078, 0),  new DigArea(new WorldPoint(2616, 3077, 0), 3)); // South of Yanille bank - Hard
        m.put(new WorldPoint(2651, 3231, 0),  new DigArea(new WorldPoint(2650, 3231, 0), 3)); // South of East Ardougne (DJP Fairy ring) - Medium
        m.put(new WorldPoint(2924, 3210, 0),  new DigArea(new WorldPoint(2924, 3209, 0), 3)); // Behind chemist's house Rimmington - Medium
        m.put(new WorldPoint(2612, 3482, 0),  new DigArea(new WorldPoint(2612, 3481, 0), 3)); // Galahad's house; McGrubor's Wood (ALS Fairy Ring) - Easy
        m.put(new WorldPoint(3110, 3152, 0),  new DigArea(new WorldPoint(3109, 3153, 0), 3)); // South of Wizard's Tower (DIS Fairy Ring) - Easy
        m.put(new WorldPoint(2970, 3415, 0),  new DigArea(new WorldPoint(2970, 3414, 0), 3)); // Crossroads north of Falador - Easy
        m.put(new WorldPoint(3043, 3398, 0),  new DigArea(new WorldPoint(3043, 3399, 0), 3)); // Standing stones north of Falador - Easy
        m.put(new WorldPoint(3166, 3361, 0),  new DigArea(new WorldPoint(3167, 3360, 0), 3)); // West of Champion Guild - Easy
        m.put(new WorldPoint(3290, 3374, 0),  new DigArea(new WorldPoint(3290, 3373, 0), 3)); // South-east Varrock mine - Easy
        m.put(new WorldPoint(3434, 3265, 0),  new DigArea(new WorldPoint(3434, 3266, 0), 3)); // South of Mort'ton (BIP Fairy Ring) - Medium
        m.put(new WorldPoint(2907, 3295, 0),  new DigArea(new WorldPoint(2906, 3294, 0), 3)); // West of Crafting Guild - Medium
        m.put(new WorldPoint(2666, 3562, 0),  new DigArea(new WorldPoint(2667, 3562, 0), 3)); // North of Seers' Village - Medium
        MAP_STEPS_CUSTOM_AREAS = Collections.unmodifiableMap(m);
    }
}