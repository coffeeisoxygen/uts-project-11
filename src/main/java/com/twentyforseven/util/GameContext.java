package com.twentyforseven.util;

import com.twentyforseven.model.algorithms.IMapRandomAlgo;
import com.twentyforseven.model.algorithms.RecursiveMazeGenerator;
import com.twentyforseven.model.classes.board.Board;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import com.twentyforseven.model.interfaces.IBoard;
import com.twentyforseven.model.interfaces.IBoardManager;
import com.twentyforseven.model.services.BoardManager;

public class GameContext {
    private static GameContext instance;
    private IBoard board;
    private ITileFactory tileFactory;
    private IMapRandomAlgo mazeGenerator;
    private IBoardManager boardManager;

    private GameContext() {
        tileFactory = new TileFactoryImpl();
        board = new Board(tileFactory); // Use default dimensions
        mazeGenerator = new RecursiveMazeGenerator(tileFactory);
        boardManager = new BoardManager();
        boardManager.createMap(6, 12, tileFactory); // Initialize the board manager with a default map
    }

    public static synchronized GameContext getInstance() {
        if (instance == null) {
            instance = new GameContext();
        }
        return instance;
    }

    public synchronized IBoard getBoard() {
        return board;
    }

    public synchronized ITileFactory getTileFactory() {
        return tileFactory;
    }

    public synchronized IMapRandomAlgo getMazeGenerator() {
        return mazeGenerator;
    }

    public synchronized IBoardManager getBoardManager() {
        return boardManager;
    }

    public synchronized void createCustomBoard(int rows, int cols) {
        board = new Board(rows, cols, tileFactory);
        boardManager.createMap(rows, cols, tileFactory);
    }
}