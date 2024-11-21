package com.twentyforseven.model.classes;

import com.twentyforseven.model.behaviors.TileStartBehavior;
import com.twentyforseven.model.enumerate.TileType;

public class TileStartPoint extends Tile {
    public TileStartPoint() {
        super(TileType.STARTPOINT, new TileStartBehavior());
    }

    public TileStartPoint(String name) {
        super(TileType.STARTPOINT, name, new TileStartBehavior());
    }

}
