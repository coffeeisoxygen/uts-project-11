package com.twentyforseven.model.classes.tile;

import java.awt.Point;

import com.twentyforseven.model.behaviors.BehaviorStartPoint;
import com.twentyforseven.model.enumerate.TileType;

public class TileStartPoint extends Tile {

    public TileStartPoint(String name, Point position) {
        super(TileType.STARTPOINT, name, new BehaviorStartPoint(), position);
    }
}