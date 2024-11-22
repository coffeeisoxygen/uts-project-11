package com.twentyforseven.model.classes.board;

import java.awt.Point;

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
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                // Example: Initialize all tiles as NORMALPOINT
                tiles[i][j] = tileFactory.createTile(TileType.NORMALPOINT, new Point(i, j));
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

    @Override
    public Integer getWidth() {
        return tiles[0].length;
    }

    @Override
    public Integer getHeight() {
        return tiles.length;
    }

    @Override
    public void printBoard() {
        for (ITile[] row : tiles) {
            for (ITile tile : row) {
                System.out.print(tile.getType().toString().charAt(0) + " ");
            }
            System.out.println();
        }
    }
}