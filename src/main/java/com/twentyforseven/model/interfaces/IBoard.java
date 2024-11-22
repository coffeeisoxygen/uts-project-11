package com.twentyforseven.model.interfaces;

import java.beans.PropertyChangeListener;

public interface IBoard {
    ITile getTile(int row, int col);

    void setTile(int row, int col, ITile tile);

    Integer getWidth();

    Integer getHeight();

    void printBoard();

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);
}