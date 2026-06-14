package io.github.danieltudose.trueclueareas.data.coordinate;

import io.github.danieltudose.trueclueareas.data.DigArea;
import net.runelite.api.coords.WorldPoint;

import java.util.*;

public class CustomCoordinateClueAreas {

    public static final Map<WorldPoint, DigArea> COORDINATE_STEPS_CUSTOM_AREAS;
    static {
        Map<WorldPoint, DigArea> m = new HashMap<>();
        //Insert here new entries;
        COORDINATE_STEPS_CUSTOM_AREAS = Collections.unmodifiableMap(m);
    }
}