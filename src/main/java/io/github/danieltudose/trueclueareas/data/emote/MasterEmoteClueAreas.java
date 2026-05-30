package io.github.danieltudose.trueclueareas.data.emote;

import io.github.danieltudose.trueclueareas.data.DigArea;
import com.google.common.collect.ImmutableMap;
import net.runelite.api.coords.WorldPoint;

import java.util.Map;

public class MasterEmoteClueAreas {
    public static final Map<String, DigArea> AREAS = new ImmutableMap.Builder<String, DigArea>()
            .put("Think on the western coast of Salvager Overlook. Beware of double agents! Equip a Hueycoatl hide coif and some Hueycoatl hide vambraces.",
                    new DigArea(new WorldPoint(1613, 3296 , 0), new WorldPoint(1610, 3305 ,0)))
            .put("Blow a kiss outside K'ril Tsutsaroth's chamber. Beware of double agents! Equip a zamorak full helm and the shadow sword..",
                    new DigArea(new WorldPoint(2924, 5333 , 2), new WorldPoint(2926, 5337 ,2)))
            .put("Show your anger at the Wise old man. Beware of double agents! Equip an abyssal whip, a legend's cape and some spined chaps.",
                    new DigArea(new WorldPoint(3088, 3251 , 0), new WorldPoint(3090, 3254 ,0)))
            .put("Bow in the Iorwerth Camp. Beware of double agents! Equip a charged crystal bow.",
                    new DigArea(new WorldPoint(2208, 3251 , 0), new WorldPoint(2202, 3255 ,0)))
            .put("Blow a raspberry in the bank of the Warriors' Guild. Beware of double agents! Equip a dragon battleaxe, a slayer helm of any kind and a dragon defender or avernic defender.",
                    new DigArea(new WorldPoint(2843, 3537, 0), new WorldPoint(2848, 3545, 0)))
            .put("Clap in the magic axe hut. Beware of double agents! Equip only some flared trousers.",
                    new DigArea(new WorldPoint(3187, 3958, 0), new WorldPoint(3194, 3962, 0)))
            .put("Salute outside the gates of Cam Torum. Beware of double agents! Equip a full set of blue moon equipment.",
                    new DigArea(new WorldPoint(1431, 3107, 0), new WorldPoint(1441, 3122, 0)))
            .put("Cry in the TzHaar gem store. Beware of double agents! Equip a fire cape and TokTz-Xil-Ul.",
                    new DigArea(new WorldPoint(2463, 5147, 0), new WorldPoint(2466, 5150, 0)))
            .put("Jump for joy in the centre of Zul-Andra. Beware of double agents! Equip a dragon 2h sword, bandos boots and an obsidian cape.",
                    new DigArea(new WorldPoint(2195, 3054, 0), new WorldPoint(2201, 3058, 0)))
            .put("Cheer in the Entrana church. Beware of double agents! Equip a full set of black dragonhide armour.",
                    new DigArea(new WorldPoint(2841, 3345, 0), new WorldPoint(2857, 3351, 0)))

            .build();
}
