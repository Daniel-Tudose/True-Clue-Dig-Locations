package com.example.data;

import net.runelite.api.coords.WorldPoint;

public class DigArea
{
    private final WorldPoint southWestCorner;
    private final WorldPoint northEastCorner;

    // Constructor 1: SW and NE corners directly
    // Use for: even-dimension rectangles like some emote clues
    public DigArea(WorldPoint southWestCorner, WorldPoint northEastCorner)
    {
        this.southWestCorner = southWestCorner;
        this.northEastCorner = northEastCorner;
    }

    // Constructor 2: center + square size
    // Use for: map clues (3x3), hot/cold (7x7, 9x9), square emote clues
    public DigArea(WorldPoint center, int size)
    {
        this(center, size, size);
    }

    // Constructor 3: center + width + height
    // Use for: odd-dimension rectangles
    // Also handles squares (same as Constructor 2)
    public DigArea(WorldPoint center, int width, int height)
    {
        int halfW = width / 2;
        int halfH = height / 2;
        this.southWestCorner = new WorldPoint(
                center.getX() - halfW,
                center.getY() - halfH,
                center.getPlane());
        this.northEastCorner = new WorldPoint(
                center.getX() + halfW,
                center.getY() + halfH,
                center.getPlane());
    }

    public WorldPoint getSouthWestCorner() { return southWestCorner; }
    public WorldPoint getNorthEastCorner() { return northEastCorner; }
}