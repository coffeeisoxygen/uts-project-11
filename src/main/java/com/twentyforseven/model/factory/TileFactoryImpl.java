package com.twentyforseven.model.factory;

import java.util.HashMap;
import java.util.Map;

import com.twentyforseven.model.classes.Tile;
import com.twentyforseven.model.classes.TileNormaltype;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.interfaces.ITile;

public class TileFactoryImpl implements ITileFactory {
    private static final Map<String, Tile> tileMap = new HashMap<>();

    @Override
    public ITile createTile(TileType type, String name) {
        String key = type + ":" + name;
        Tile tile = tileMap.get(key);
        if (tile == null) {
            tile = switch (type) {
                case NORMALPOINT -> new TileNormaltype(name);
                default -> new TileNormaltype(name);
            }; // Add cases for other tile types
            tileMap.put(key, tile);
        }
        return tile;
    }

    @Override
    public ITile createTile(TileType type) {
        return createTile(type, type.toString());
    }
}