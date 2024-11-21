package com.twentyforseven.model.classes;

import com.twentyforseven.model.behaviors.TileDangerBehavior;
import com.twentyforseven.model.enumerate.TileType;

public class TileDangerPoint extends Tile {

    public TileDangerPoint() {
        super(TileType.DANGERPOINT, new TileDangerBehavior());
    }

    public TileDangerPoint(String name) {
        super(TileType.DANGERPOINT, name, new TileDangerBehavior());
    }

}
