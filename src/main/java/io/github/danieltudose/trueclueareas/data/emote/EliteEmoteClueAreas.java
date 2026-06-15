package io.github.danieltudose.trueclueareas.data.emote;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;

import java.util.Map;

public class EliteEmoteClueAreas {
    public static final Map<String, DigArea> AREAS = new ImmutableMap.Builder<String, DigArea>()
            .put("Jump for joy in the Ancient Cavern. Equip a granite shield, splitbark body and any rune heraldic helm.",
                    new DigArea(new WorldPoint(1763, 5365, 1), new WorldPoint(1768, 5367, 1)))
            .put("Headbang at the top of Slayer Tower. Equip a seercull, a combat bracelet and helm of Neitiznot.",
                    new DigArea(new WorldPoint(3405, 3531, 2), new WorldPoint(3452, 3579, 2)))
            .put("Spin in West Ardougne Church. Equip a dragon spear and red dragonhide chaps.",
                    new DigArea(new WorldPoint(2524, 3285, 0), new WorldPoint(2532, 3295, 0)))
            .put("Blow a kiss in the heart of the lava maze. Equip black dragonhide chaps, a spotted cape and a rolling pin.",
                    new DigArea(new WorldPoint(3064, 3856, 0), new WorldPoint(3071, 3863, 0)))
            .put("Yawn at the top of Trollheim. Equip a lava battlestaff, black dragonhide vambraces and a mind shield.",
                    new DigArea(new WorldPoint(2886, 3674, 0), new WorldPoint(2895, 3682, 0)))
            .put("Dance on the fishing platform. Equip barrows gloves, an amulet of glory and a dragon med helm.",
                    new DigArea(new WorldPoint(2762, 3273, 0), new WorldPoint(2794, 3291, 0)))
            .put("Laugh by the fountain of heroes. Equip splitbark legs, dragon boots and a Rune longsword.",
                    new DigArea(new WorldPoint(2914, 9891, 0), new WorldPoint(2921, 9896, 0)))
            .put("Panic at the area flowers meet snow. Equip Blue D'hide vambraces, a dragon spear and a rune plateskirt.",
                    new DigArea(new WorldPoint(27874, 3779, 0), new WorldPoint(2782, 3786, 0)))
            .put("Bow within the temple in Civitas illa Fortis. Equip any piece of sunfire fanatic armour.",
                    new DigArea(new WorldPoint(1697, 3085, 0), new WorldPoint(1701, 3088, 0)))
            .build();
}
