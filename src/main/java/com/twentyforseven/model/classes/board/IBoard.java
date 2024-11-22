package com.twentyforseven.model.classes.board;

import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.interfaces.PropertyChangeObservable;

public interface IBoard extends PropertyChangeObservable {
    ITile getTile(int row, int col);

    void setTile(int row, int col, ITile tile);

    Integer getWidth();

    Integer getHeight();

    void printBoard();
}