package com.twentyforseven.model.classes;

import com.twentyforseven.model.behaviors.TileNormalBehavior;
import com.twentyforseven.model.enumerate.TileType;

public class TileNormalPoint extends Tile {

    public TileNormalPoint() {
        super(TileType.NORMALPOINT, new TileNormalBehavior());
    }

    public TileNormalPoint(String name) {
        super(TileType.NORMALPOINT, name, new TileNormalBehavior());
    }
}