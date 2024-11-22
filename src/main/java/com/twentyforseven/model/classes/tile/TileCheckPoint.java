package com.twentyforseven.model.classes.tile;

import java.awt.Point;

import com.twentyforseven.model.behaviors.TileCheckPBehavior;
import com.twentyforseven.model.enumerate.TileType;

public class TileCheckPoint extends Tile {

    public TileCheckPoint(String name, Point position) {
        super(TileType.CHECKPOINT, name, new TileCheckPBehavior(), position);
    }
}