package com.twentyforseven.model.classes;

import java.awt.Point;

import com.twentyforseven.model.behaviors.TileFinishPBehavior;
import com.twentyforseven.model.enumerate.TileType;

public class TileFinishPoint extends Tile {

    public TileFinishPoint(String name, Point position) {
        super(TileType.FINISHPOINT, name, new TileFinishPBehavior(), position);
    }
}