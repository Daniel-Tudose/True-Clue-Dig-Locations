package io.github.danieltudose.trueclueareas.data.emote;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;

import java.util.Map;

public class HardEmoteClueAreas {
    public static final Map<String, DigArea> AREAS = new ImmutableMap.Builder<String, DigArea>()
            .put("Panic on the Wilderness volcano bridge. Beware of double agents! Equip any headband and crozier.",
                    new DigArea(new WorldPoint(3361, 3935, 0), new WorldPoint(3373, 3936, 0)))
            .put("Beckon on the east coast of the Kharazi Jungle. Beware of double agents! Equip any vestment stole and a heraldic rune shield.",
                    new DigArea(new WorldPoint(2949,2883, 0), new WorldPoint(2971,2945, 0)))
            .put("Panic outside the Twilight Temple. Beware of double agents! Equip a rune longsword, rune platebody and a rune plateskirt.",
                    new DigArea(new WorldPoint(1692, 3242, 0), new WorldPoint(1697, 3253, 0)))
            .put("Blow a raspberry in the Fishing Guild bank. Beware of double agents! Equip an elemental shield, blue dragonhide chaps and a rune warhammer.",
                    new DigArea(
                            new WorldPoint(2586, 3418, 0), new WorldPoint(2589, 3422, 0),
                            new WorldPoint(2588, 3413, 0), new WorldPoint(2592, 3419, 0)
                    ))
            .put("Shrug in the woods east of the Level 19 Wilderness Obelisk. Beware of double agents! Equip rune platelegs, an iron platebody and blue dragonhide vambraces.",
                    new DigArea(new WorldPoint(3239, 3668, 0), new WorldPoint(3243, 3674, 0)))
            .put("Panic in the heart of the Haunted Woods. Beware of double agents! Have no items equipped when you do.",
                    new DigArea(new WorldPoint(3611, 3483, 0), new WorldPoint(3621, 3493, 0)))
            .put("Bow at the top of the lighthouse. Beware of double agents! Equip a blue dragonhide body, blue dragonhide vambraces and no jewelry.",
                    new DigArea(new WorldPoint(2504, 3637, 2), new WorldPoint(2513, 3645, 2)))
            .put("Laugh in Jokul's tent in the Mountain Camp. Beware of double agents! Equip a rune full helmet, blue dragonhide chaps and a fire battlestaff.",
                    new DigArea(new WorldPoint(2811, 3680, 0), new WorldPoint(2813, 3681, 0)))
            .put("Headbang at the exam centre. Beware of double agents! Equip a mystic fire staff, a diamond bracelet and rune boots.",
                    new DigArea(new WorldPoint(3357, 3332, 0), new WorldPoint(3367, 3348, 0)))
            .put("Panic by the pilot on White Wolf Mountain. Beware of double agents! Equip mithril platelegs, a ring of life and a rune axe.",
                    new DigArea(new WorldPoint(2845, 3497, 0), new WorldPoint(2849, 3501, 0)))
            .build();
}
