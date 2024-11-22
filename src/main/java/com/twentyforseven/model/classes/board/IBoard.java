package com.twentyforseven.model.classes.board;

import com.twentyforseven.model.classes.tile.ITile;

public interface IBoard {
    ITile getTile(int row, int col);

    void setTile(int row, int col, ITile tile);

    Integer getWidth();

    Integer getHeight();

    void printBoard();

}