package com.twentyforseven.model.classes.tile;

import java.awt.Point;

import com.twentyforseven.model.behaviors.BehaviorDangerPoint;
import com.twentyforseven.model.enumerate.TileType;

public class TileDangerPoint extends Tile {

    public TileDangerPoint(String name, Point position) {
        super(TileType.DANGERPOINT, name, new BehaviorDangerPoint(), position);
    }
}