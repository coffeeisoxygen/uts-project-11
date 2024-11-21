package com.twentyforseven.model.classes;

import com.twentyforseven.model.behaviors.TileCheckPointBehavior;
import com.twentyforseven.model.enumerate.TileType;

public class TileCheckPoint extends Tile {

    public TileCheckPoint() {
        super(TileType.CHECKPOINT, new TileCheckPointBehavior());
    }

    public TileCheckPoint(String name) {
        super(TileType.CHECKPOINT, name, new TileCheckPointBehavior());
    }

}
