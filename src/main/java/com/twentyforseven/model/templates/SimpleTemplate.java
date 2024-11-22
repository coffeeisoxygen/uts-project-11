package com.twentyforseven.model.templates;

import java.awt.Point;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.interfaces.IBoard;
import com.twentyforseven.model.interfaces.ITile;
import com.twentyforseven.model.factory.ITileFactory;

public class SimpleTemplate extends MapTemplate {
    @Override
    protected void initializeTemplate(IBoard board) {
        // Initialize the board with default tiles
        ITileFactory tileFactory = board.getTileFactory();
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                ITile tile = tileFactory.createTile(TileType.NORMALPOINT, new Point(i, j));
                board.setTile(i, j, tile);
            }
        }
    }

    @Override
    protected void placeTiles(IBoard board) {
        // Place specific tiles for the simple template
        ITileFactory tileFactory = board.getTileFactory();
        board.setTile(0, 0, tileFactory.createTile(TileType.STARTPOINT, new Point(0, 0)));
        board.setTile(board.getHeight() - 1, board.getWidth() - 1, tileFactory.createTile(TileType.FINISHPOINT, new Point(board.getHeight() - 1, board.getWidth() - 1)));
    }
}