package com.twentyforseven;

import com.twentyforseven.model.classes.Board;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import com.twentyforseven.model.interfaces.IBoard;

public class Main {
    public static void main(String[] args) {
        ITileFactory tileFactory = new TileFactoryImpl();
        IBoard board = new Board(6, 12, tileFactory);
        board.printBoard();

        // Example: Get a tile from the board
        System.out.println(board.getTile(0, 0));
    }
}