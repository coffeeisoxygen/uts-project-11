package com.twentyforseven;

import com.twentyforseven.model.classes.Board;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;

public class Main {
    public static void main(String[] args) {
        ITileFactory tileFactory = new TileFactoryImpl();
        Board board = new Board(10, 10, tileFactory);

        // Example: Get a tile from the board
        System.out.println(board.getTile(0, 0));
    }
}