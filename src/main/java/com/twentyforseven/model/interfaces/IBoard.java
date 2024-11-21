package com.twentyforseven.model.interfaces;

public interface IBoard {

    ITile getTile(int row, int col);

    void setTile(int row, int col, ITile tile);

}