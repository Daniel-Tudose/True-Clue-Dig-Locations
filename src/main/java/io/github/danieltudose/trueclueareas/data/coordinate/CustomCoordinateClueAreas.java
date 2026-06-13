package io.github.danieltudose.trueclueareas.data.coordinate;

import io.github.danieltudose.trueclueareas.data.DigArea;
import net.runelite.api.coords.WorldPoint;

import java.util.*;

public class CustomCoordinateClueAreas {

    public static final Map<WorldPoint, DigArea> COORDINATE_STEPS_CUSTOM_AREAS;
    static {
        Map<WorldPoint, DigArea> m = new HashMap<>();
        // Key = base plugin's stored WorldPoint
        // Value = corrected DigArea
        // Example:
        // m.put(new WorldPoint(x, y, 0), new DigArea(new WorldPoint(sw_x, sw_y, 0), new WorldPoint(ne_x, ne_y, 0)));
        COORDINATE_STEPS_CUSTOM_AREAS = Collections.unmodifiableMap(m);
    }
}