package com.example;

import com.example.data.DigArea;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.cluescrolls.clues.hotcold.HotColdLocation;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.api.Point;

import javax.inject.Inject;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Set;
@Slf4j
public class TrueClueAreasOverlay extends Overlay {
    private final Client client;
    private final TrueClueAreasConfig config;

    public enum ClueType { MAP, EMOTE, HOT_COLD }

    private DigArea digArea = null;
    private ClueType digAreaType = null;
    private Set<HotColdLocation> hotColdLocations = null;

    @Inject
    public TrueClueAreasOverlay(Client client, TrueClueAreasConfig config) {
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_SCENE);
        this.client = client;
        this.config = config;
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (digArea != null && digAreaType != null)
        {
            boolean shouldShow = digAreaType == ClueType.MAP
                    ? config.showMapClues()
                    : config.showEmoteClues();

            if (shouldShow)
            {
                Color color = digAreaType == ClueType.MAP
                        ? config.mapClueColor()
                        : config.emoteClueColor();

                renderArea(graphics,
                        digArea.getSouthWestCorner(),
                        digArea.getNorthEastCorner(),
                        new Color(color.getRed(), color.getGreen(), color.getBlue(), 50),
                        new Color(color.getRed(), color.getGreen(), color.getBlue(), 200));
            }
        }

        if (hotColdLocations != null && config.showHotColdClues())
        {
            Color color = config.hotColdColor();
            for (HotColdLocation location : hotColdLocations)
            {
                java.awt.Rectangle rect = location.getRect();
                WorldPoint sw = new WorldPoint(
                        rect.x,
                        rect.y,
                        location.getWorldPoint().getPlane());
                WorldPoint ne = new WorldPoint(
                        rect.x + rect.width - 1,
                        rect.y + rect.height - 1,
                        location.getWorldPoint().getPlane());
                renderArea(graphics, sw, ne,
                        new Color(color.getRed(), color.getGreen(), color.getBlue(), 50),
                        new Color(color.getRed(), color.getGreen(), color.getBlue(), 200));
            }
        }
        return null;
    }

    private void renderArea(Graphics2D graphics,
                            WorldPoint sw, WorldPoint ne,
                            Color fillColor, Color borderColor)
    {
        LocalPoint swLocal = LocalPoint.fromWorld(client, sw);
        LocalPoint neLocal = LocalPoint.fromWorld(client, ne);
        if (swLocal == null || neLocal == null) return;

        final int HALF = 64;
        int x1 = swLocal.getX() - HALF;
        int y1 = swLocal.getY() - HALF;
        int x2 = neLocal.getX() + HALF;
        int y2 = neLocal.getY() + HALF;

        Point p1 = Perspective.localToCanvas(client,
                new LocalPoint(x1, y1, swLocal.getWorldView()), sw.getPlane());
        Point p2 = Perspective.localToCanvas(client,
                new LocalPoint(x1, y2, swLocal.getWorldView()), sw.getPlane());
        Point p3 = Perspective.localToCanvas(client,
                new LocalPoint(x2, y2, neLocal.getWorldView()), ne.getPlane());
        Point p4 = Perspective.localToCanvas(client,
                new LocalPoint(x2, y1, neLocal.getWorldView()), ne.getPlane());

        if (p1 == null || p2 == null || p3 == null || p4 == null) return;

        Polygon poly = new Polygon();
        poly.addPoint(p1.getX(), p1.getY());
        poly.addPoint(p2.getX(), p2.getY());
        poly.addPoint(p3.getX(), p3.getY());
        poly.addPoint(p4.getX(), p4.getY());

        graphics.setColor(fillColor);
        graphics.fill(poly);
        graphics.setColor(borderColor);
        graphics.setStroke(new BasicStroke(2));
        graphics.draw(poly);
    }

    public void setDigArea(DigArea area, ClueType type) {
        this.digArea = area;
        this.digAreaType = type;
    }

    public void setDigArea(DigArea area) {
        this.digArea = area;
        this.digAreaType = null;
    }

    public void setHotColdLocations(Set<HotColdLocation> locations) {
        this.hotColdLocations = locations;
    }

    public boolean hasActiveArea() {
        return digArea != null || hotColdLocations != null;
    }
}