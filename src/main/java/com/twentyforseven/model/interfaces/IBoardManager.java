package com.twentyforseven.model.interfaces;

import java.awt.Point;

import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;

public interface IBoardManager {
    void createMap(int rows, int cols, ITileFactory tileFactory);
    void placeTile(TileType type, Point position);
    void loadTemplate(String templateName);
    void saveMap(String fileName);
    void loadMap(String fileName);
    void printBoard();
}