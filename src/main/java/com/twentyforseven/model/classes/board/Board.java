package com.twentyforseven.model.classes.board;

import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;

public class Board implements IBoard {
    private static final Logger logger = Logger.getLogger(Board.class.getName());
    private static final int DEFAULT_ROWS = 6;
    private static final int DEFAULT_COLS = 12;
    private ITile[][] tiles;
    private ITileFactory tileFactory;
    private PropertyChangeSupport support;

    // Constructor with parameters for rows, cols, and tileFactory
    public Board(int rows, int cols, ITileFactory tileFactory) {
        this.tiles = new ITile[rows][cols];
        this.tileFactory = tileFactory;
        this.support = new PropertyChangeSupport(this);
        initializeBoard();
    }

    // Constructor without parameters, using default rows and cols
    public Board(ITileFactory tileFactory) {
        this(DEFAULT_ROWS, DEFAULT_COLS, tileFactory);
    }

    private void initializeBoard() {
        try {
            for (int i = 0; i < tiles.length; i++) {
                for (int j = 0; j < tiles[i].length; j++) {
                    tiles[i][j] = tileFactory.createTile(TileType.NORMALPOINT, new Point(i, j));
                    // place tile start at last row and last column
                    if (i == tiles.length - 1 && j == tiles[i].length - 1) {
                        tiles[i][j] = tileFactory.createTile(TileType.STARTPOINT, new Point(i, j));
                    }
                    // place tile finish at first row and first column
                    if (i == 0 && j == 0) {
                        tiles[i][j] = tileFactory.createTile(TileType.FINISHPOINT, new Point(i, j));
                    }
                }
            }
            logger.info("Board initialized successfully.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to initialize the board: {0}", e.getMessage());
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
        for (ITile[] tile : tiles) {
            for (ITile tile1 : tile) {
                logger.log(Level.INFO, "{0} ", tile1.getType().toString().charAt(0));
            }
            logger.info("Printed board successfully.");
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