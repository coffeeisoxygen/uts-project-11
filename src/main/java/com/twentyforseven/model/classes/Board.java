package com.twentyforseven.model.classes;

import java.awt.Point;

import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.interfaces.ITile;

public class Board {
    private ITile[][] tiles;
    private ITileFactory tileFactory;

    public Board(int rows, int cols, ITileFactory tileFactory) {
        this.tiles = new ITile[rows][cols];
        this.tileFactory = tileFactory;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                // Example: Initialize all tiles as NORMALPOINT
                tiles[i][j] = tileFactory.createTile(TileType.NORMALPOINT, new Point(i, j));
            }
        }
    }

    public ITile getTile(int row, int col) {
        return tiles[row][col];
    }

    public void setTile(int row, int col, ITile tile) {
        tiles[row][col] = tile;
    }

    public Integer getWidth() {
        return tiles[0].length;
    }

    public Integer getHeight() {
        return tiles.length;
    }

    public void printBoard() {
        for (ITile[] tile : tiles) {
            for (ITile tile1 : tile) {
                System.out.print(tile1.getType().toString().charAt(0) + " ");
            }
            System.out.println();
        }
    }
}