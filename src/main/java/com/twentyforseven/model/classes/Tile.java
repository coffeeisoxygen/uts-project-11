package com.twentyforseven.model.classes;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.twentyforseven.model.behaviors.ITileBehavior;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.interfaces.ITile;

public class Tile implements ITile {
    private String name;
    private TileType type;
    private Color color;
    private ITileBehavior behavior;
    private static final Map<TileType, Color> DEFAULT_COLORS = new HashMap<>();

    static {
        DEFAULT_COLORS.put(TileType.CHECKPOINT, Color.GREEN);
        DEFAULT_COLORS.put(TileType.STARTPOINT, Color.BLUE);
        DEFAULT_COLORS.put(TileType.FINISHPOINT, Color.RED);
        DEFAULT_COLORS.put(TileType.DANGERPOINT, Color.YELLOW);
        DEFAULT_COLORS.put(TileType.NORMALPOINT, Color.WHITE);
    }

    public Tile(TileType type, ITileBehavior behavior) {
        this(type, type != null ? type.toString() : TileType.NORMALPOINT.toString(), behavior);
    }

    public Tile(TileType type, String name, ITileBehavior behavior) {
        this.type = type != null ? type : TileType.NORMALPOINT;
        this.name = name != null ? name : this.type.toString();
        this.color = DEFAULT_COLORS.get(this.type);
        this.behavior = behavior;
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
        this.type = type != null ? type : TileType.NORMALPOINT;
        this.color = DEFAULT_COLORS.get(this.type);
    }

    @Override
    public void setName(String name) {
        this.name = name != null ? name : this.type.toString();
    }

    @Override
    public String toString() {
        return "Tile{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", color=" + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Tile tile = (Tile) o;
        return Objects.equals(name, tile.name) && type == tile.type && Objects.equals(color, tile.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, color);
    }

    @Override
    public void interact(Player player) {
        behavior.interact(player);
    }
}