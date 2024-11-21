package com.twentyforseven.model.classes;

import com.twentyforseven.model.behaviors.TileFinishBehavior;
import com.twentyforseven.model.enumerate.TileType;

public class TileFinishPoint extends Tile {

    public TileFinishPoint() {
        super(TileType.FINISHPOINT, new TileFinishBehavior());
    }

    public TileFinishPoint(String name) {
        super(TileType.FINISHPOINT, name, new TileFinishBehavior());
    }

}
