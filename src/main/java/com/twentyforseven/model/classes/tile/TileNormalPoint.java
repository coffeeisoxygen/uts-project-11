package com.twentyforseven.model.classes.tile;

import java.awt.Point;

import com.twentyforseven.model.behaviors.BehaviorNormalPoint;
import com.twentyforseven.model.enumerate.TileType;

public class TileNormalPoint extends Tile {

    public TileNormalPoint(String name, Point position) {
        super(TileType.NORMALPOINT, name, new BehaviorNormalPoint(), position);
    }
}