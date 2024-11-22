package com.twentyforseven.model.classes.board;

import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.interfaces.IBoard;
import com.twentyforseven.model.interfaces.ITile;

public class Board implements IBoard {
    private ITile[][] tiles;
    private ITileFactory tileFactory;
    private PropertyChangeSupport support;

    public Board(int rows, int cols, ITileFactory tileFactory) {
        this.tiles = new ITile[rows][cols];
        this.tileFactory = tileFactory;
        this.support = new PropertyChangeSupport(this);
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
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
        ITile oldTile = tiles[row][col];
        tiles[row][col] = tile;
        support.firePropertyChange("tile", oldTile, tile);
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

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}