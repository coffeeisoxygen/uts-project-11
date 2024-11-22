package com.twentyforseven;

import com.twentyforseven.model.commands.LoadMapCommand;
import com.twentyforseven.model.commands.SaveMapCommand;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import com.twentyforseven.model.interfaces.IBoardManager;
import com.twentyforseven.model.services.BoardManager;

public class Main {
    public static void main(String[] args) {
        ITileFactory tileFactory = new TileFactoryImpl();
        IBoardManager boardManager = new BoardManager();

        // Create a new map
        boardManager.createMap(6, 12, tileFactory);
        boardManager.printBoard();

        // Save the map
        SaveMapCommand saveCommand = new SaveMapCommand(boardManager, "map.dat");
        saveCommand.execute();

        // Load the map
        LoadMapCommand loadCommand = new LoadMapCommand(boardManager, "map.dat");
        loadCommand.execute();
        boardManager.printBoard();
    }
}