package com.twentyforseven.model.classes;

import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.interfaces.IBoard;
import com.twentyforseven.model.interfaces.ITile;

public class Board implements IBoard {
    private ITile[][] tiles;
    private ITileFactory tileFactory;

    public Board(int rows, int cols, ITileFactory tileFactory) {
        this.tiles = new ITile[rows][cols];
        this.tileFactory = tileFactory;
        initializeBoard();
    }

    private void initializeBoard() {
        for (ITile[] tile : tiles) {
            for (int j = 0; j < tile.length; j++) {
                // Example: Initialize all tiles as NORMALPOINT
                tile[j] = tileFactory.createTile(TileType.NORMALPOINT);
            }
        }
    }

    @Override
    public ITile getTile(int row, int col) {
        return tiles[row][col];
    }

    @Override
    public void setTile(int row, int col, ITile tile) {
        tiles[row][col] = tile;
    }
}