package com.twentyforseven.model.classes.tile;

import java.awt.Point;

import com.twentyforseven.model.behaviors.BehaviorFinishPoint;
import com.twentyforseven.model.enumerate.TileType;

public class TileFinishPoint extends Tile {

    public TileFinishPoint(String name, Point position) {
        super(TileType.FINISHPOINT, name, new BehaviorFinishPoint(), position);
    }
}