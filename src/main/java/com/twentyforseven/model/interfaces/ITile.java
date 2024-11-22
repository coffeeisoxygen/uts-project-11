package com.twentyforseven.model.interfaces;

import java.awt.Color;
import java.awt.Point;

import com.twentyforseven.model.classes.player.Player;
import com.twentyforseven.model.enumerate.TileType;

public interface ITile {
    TileType getType();

    Color getColor();

    void setColor(Color color);

    String getName();

    void setType(TileType type);

    void setName(String name);

    Point getPosition();

    void setPosition(Point position);

    void interact(Player player);
}