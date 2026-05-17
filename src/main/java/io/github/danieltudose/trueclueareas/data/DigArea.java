package io.github.danieltudose.trueclueareas.data;

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

@Getter
public class DigArea {
    private final WorldPoint southWestCorner;
    private final WorldPoint northEastCorner;

    public DigArea(WorldPoint southWestCorner, WorldPoint northEastCorner) {
        this.southWestCorner = southWestCorner;
        this.northEastCorner = northEastCorner;
    }

    public DigArea(WorldPoint center, int size) {
        this(center, size, size);
    }

    public DigArea(WorldPoint center, int width, int height) {
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

}