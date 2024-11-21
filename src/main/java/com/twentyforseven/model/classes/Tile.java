package com.twentyforseven.model.classes;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.interfaces.ITile;

public abstract class Tile implements ITile {
    private String name;

    private TileType type;
    private Color color;
    private static final Map<TileType, Color> DEFAULT_COLORS = new HashMap<>();

    static {
        DEFAULT_COLORS.put(TileType.CHECKPOINT, Color.GREEN);
        DEFAULT_COLORS.put(TileType.STARTPOINT, Color.BLUE);
        DEFAULT_COLORS.put(TileType.FINISHPOINT, Color.RED);
        DEFAULT_COLORS.put(TileType.DANGERPOINT, Color.YELLOW);
        DEFAULT_COLORS.put(TileType.NORMALPOINT, Color.WHITE);
    }

    // constructor with tile only
    public Tile(TileType type) {
        this.name = type.toString();
        this.type = type;
        this.color = DEFAULT_COLORS.get(type);
    }

    // constructor with tile and name
    public Tile(TileType type, String name) {
        this.name = name;
        this.type = type;
        this.color = DEFAULT_COLORS.get(type);
    }

    @Override
    public TileType getType() {
        return type;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    public static Color getDefaultColor(TileType type) {
        return DEFAULT_COLORS.get(type);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setType(TileType type) {
        this.type = type;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
