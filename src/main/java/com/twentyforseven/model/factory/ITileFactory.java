package com.twentyforseven.model.factory;

import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.interfaces.ITile;

public interface ITileFactory {
    ITile createTile(TileType type, String name);

    ITile createTile(TileType type);
}