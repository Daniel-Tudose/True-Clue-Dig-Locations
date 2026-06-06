package io.github.danieltudose.trueclueareas.data;

import net.runelite.api.coords.WorldPoint;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DigArea {
    private final List<WorldPoint> southWestCorners;
    private final List<WorldPoint> northEastCorners;

    // Single rectangle from explicit corners
    public DigArea(WorldPoint sw, WorldPoint ne) {
        this.southWestCorners = Collections.singletonList(sw);
        this.northEastCorners = Collections.singletonList(ne);
    }

    // Single rectangle from center + square size
    public DigArea(WorldPoint center, int size) {
        this(center, size, size);
    }

    // Single rectangle from center + width/height
    public DigArea(WorldPoint center, int width, int height) {
        int halfW = width / 2;
        int halfH = height / 2;
        this.southWestCorners = Collections.singletonList(
                new WorldPoint(center.getX() - halfW, center.getY() - halfH, center.getPlane()));
        this.northEastCorners = Collections.singletonList(
                new WorldPoint(center.getX() + halfW, center.getY() + halfH, center.getPlane()));
    }

    // Two separate rectangles — for cases like the composite emote areas
    public DigArea(WorldPoint sw1, WorldPoint ne1, WorldPoint sw2, WorldPoint ne2) {
        this.southWestCorners = Arrays.asList(sw1, sw2);
        this.northEastCorners = Arrays.asList(ne1, ne2);
    }

    public int getRectCount() {
        return southWestCorners.size();
    }

    public WorldPoint getSouthWestCorner() {
        return southWestCorners.get(0);
    }

    public WorldPoint getNorthEastCorner() {
        return northEastCorners.get(0);
    }

    public WorldPoint getSouthWestCorner(int i) {
        return southWestCorners.get(i);
    }

    public WorldPoint getNorthEastCorner(int i) {
        return northEastCorners.get(i);
    }
}