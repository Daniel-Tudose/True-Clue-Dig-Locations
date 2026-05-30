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
            .build();
}
