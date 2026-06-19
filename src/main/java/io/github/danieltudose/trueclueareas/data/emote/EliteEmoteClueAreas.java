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
            .put("Cheer in the Shadow dungeon. Equip a rune crossbow, climbing boots and any mitre.",
                    new DigArea(new WorldPoint(2625, 5057, 0), new WorldPoint(2749, 5118, 0)))
            .put("Headbang in the Fight Arena pub. Equip a pirate bandana, a dragonstone necklace and and a magic longbow.",
                    new DigArea(new WorldPoint(2563, 3139, 0), new WorldPoint(2570, 3150, 0)))
            .put("Laugh in front of the gem store in Ardougne market. Equip a Castlewars bracelet, a dragonstone amulet and a ring of forging.",
                    new DigArea(new WorldPoint(2664, 3301, 0), new WorldPoint(2671, 3306, 0)))
            .put("Bow upstairs in the Edgeville Monastery. Equip a completed prayer book.",
                    new DigArea(new WorldPoint(3044, 3482, 1), new WorldPoint(3059, 3499, 1)))
            .put("Salute in the Warriors' Guild bank. Equip only a black salamander.",
                    new DigArea(new WorldPoint(2843, 3537, 0), new WorldPoint(2848, 3545, 0)))
            .put("Jump for joy at the Neitiznot rune rock. Equip Rune boots, a proselyte hauberk and a dragonstone ring.",
                    new DigArea(new WorldPoint(2373, 3848, 0), new WorldPoint(2377, 3852, 0)))
            .put("Bow on the ground floor of the Legends' Guild. Equip a Cape of Legends, a dragon battleaxe and an amulet of glory.",
                    new DigArea(new WorldPoint(2723, 3374, 0), new WorldPoint(2735, 3381, 0)))
            .build();
}
