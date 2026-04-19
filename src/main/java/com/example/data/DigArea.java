package com.example.data;

// We need WorldPoint from the RuneLite API — this import lets us use it
import net.runelite.api.coords.WorldPoint;

/*
 Represents the actual dig area for a clue scroll step.
 * Java concept: this is a plain "data class" — it just holds values
 * and provides ways to read them. No game logic lives here.
 */
public class DigArea
{
    // 'private final' = this value is set once in the constructor and never changes.
    // 'private' = only code inside THIS class can read it directly.
    // We expose it via a getter method below (encapsulation).
    private final WorldPoint center;
    private final int width;   // in tiles, east-west
    private final int height;  // in tiles, north-south

    /*
     Constructor for the common SQUARE case (e.g., most clues are 3x3).

     Java concept: Constructor OVERLOADING — two constructors with the same
     name but different parameters. Java picks the right one based on what
     arguments you pass.

     'this(...)' calls the other constructor below — avoids repeating code.
     */
    public DigArea(WorldPoint center, int size)
    {
        this(center, size, size);  // delegates to the rectangle constructor
    }

    /**
     * Constructor for RECTANGLE areas.
     *
     * This is the "real" constructor — the one above just calls this.
     */
    public DigArea(WorldPoint center, int width, int height)
    {
        this.center = center;
        this.width = width;
        this.height = height;
    }

    /**
     Returns the SOUTH-WEST corner of the area.

     Why SW corner? RuneLite's Perspective.getCanvasTileAreaPoly() expects
     the SW corner as its starting point, then draws width tiles east
     and height tiles north from there.
     */
    public WorldPoint getSouthWestCorner()
    {
        return new WorldPoint(
                center.getX() - width / 2,
                center.getY() - height / 2,
                center.getPlane()            // plane = which floor (0=surface, 1=upstairs, etc.)
        );
    }

    // "Getters" — the standard Java way to expose private fields safely
    public WorldPoint getCenter() { return center; }
    public int getWidth()         { return width; }
    public int getHeight()        { return height; }
}