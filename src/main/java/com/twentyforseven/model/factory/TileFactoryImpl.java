package com.twentyforseven.model.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.twentyforseven.model.classes.Tile;
import com.twentyforseven.model.classes.TileCheckPoint;
import com.twentyforseven.model.classes.TileDangerPoint;
import com.twentyforseven.model.classes.TileFinishPoint;
import com.twentyforseven.model.classes.TileNormalPoint;
import com.twentyforseven.model.classes.TileStartPoint;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.interfaces.ITile;

public class TileFactoryImpl implements ITileFactory {
    private static final Map<String, Tile> tileMap = new ConcurrentHashMap<>();

    @Override
    public ITile createTile(TileType type, String name) {
        String key = type + ":" + name;
        return tileMap.computeIfAbsent(key, _ -> {
            return switch (type) {
                case NORMALPOINT -> new TileNormalPoint(name);
                case CHECKPOINT -> new TileCheckPoint(name);
                case DANGERPOINT -> new TileDangerPoint(name);
                case STARTPOINT -> new TileStartPoint(name);
                case FINISHPOINT -> new TileFinishPoint(name);
                default -> new TileNormalPoint(name);
            };
        });
    }

    @Override
    public ITile createTile(TileType type) {
        return createTile(type, type.toString());
    }
}