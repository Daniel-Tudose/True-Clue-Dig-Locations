package io.github.danieltudose.trueclueareas.data.emote;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;

import java.util.Map;

public class MediumEmoteClueAreas {
    public static final Map<String, DigArea> AREAS = new ImmutableMap.Builder<String, DigArea>()
            .put("Jump for Joy in the mine near the Twilight Temple. Bow before you talk to me. Equip a maple longbow, a ruby amulet and some steel platelegs.",
                    new DigArea(new WorldPoint(1668, 3280, 0), new WorldPoint(1676, 3286,0)))
            .build();
}
