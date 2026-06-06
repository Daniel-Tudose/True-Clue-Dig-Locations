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
            .build();
}
