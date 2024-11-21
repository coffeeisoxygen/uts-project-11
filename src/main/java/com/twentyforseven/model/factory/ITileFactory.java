package com.twentyforseven.model.factory;

import java.awt.Point;

import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.interfaces.ITile;

public interface ITileFactory {
    ITile createTile(TileType type, String name, Point position);

    ITile createTile(TileType type, Point position);
}