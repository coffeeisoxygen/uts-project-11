package com.twentyforseven.model.factory;

import java.awt.Point;
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
    public ITile createTile(TileType type, String name, Point position) {
        String key = type + ":" + name + ":" + position;
        return tileMap.computeIfAbsent(key, _ -> {
            return switch (type) {
                case NORMALPOINT -> new TileNormalPoint(name, position);
                case CHECKPOINT -> new TileCheckPoint(name, position);
                case DANGERPOINT -> new TileDangerPoint(name, position);
                case STARTPOINT -> new TileStartPoint(name, position);
                case FINISHPOINT -> new TileFinishPoint(name, position);
                default -> new TileNormalPoint(name, position);
            };
        });
    }

    @Override
    public ITile createTile(TileType type, Point position) {
        return createTile(type, type.toString(), position);
    }
}