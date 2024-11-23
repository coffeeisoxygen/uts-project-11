package com.twentyforseven.util;

import java.awt.Point;

import com.twentyforseven.model.algorithms.IMapRandomAlgo;
import com.twentyforseven.model.algorithms.SimpleMapMaze;
import com.twentyforseven.model.classes.board.Board;
import com.twentyforseven.model.classes.board.IBoard;
import com.twentyforseven.model.classes.player.Player;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import com.twentyforseven.model.interfaces.IBoardManager;
import com.twentyforseven.model.services.BoardManager;
import com.twentyforseven.model.services.GameManager;

public class GameContext {
    private static GameContext instance;
    private IBoard board;
    private ITileFactory tileFactory;
    private IMapRandomAlgo mazeGenerator;
    private IBoardManager boardManager;
    private GameManager gameManager;

    private GameContext() {
        tileFactory = new TileFactoryImpl();
        board = new Board(tileFactory); // Use default dimensions
        mazeGenerator = new SimpleMapMaze(tileFactory);
        boardManager = new BoardManager();
        boardManager.createMap(6, 12, tileFactory); // Initialize the board manager with a default map
        Player player = new Player("Player1", 0, new Point(0, 0));
        gameManager = new GameManager(player, board);
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

    public synchronized GameManager getGameManager() {
        return gameManager;
    }

    public synchronized void createCustomBoard(int rows, int cols) {
        board = new Board(rows, cols, tileFactory);
        boardManager.createMap(rows, cols, tileFactory);
        Player player = new Player("Player1", 0, new Point(3, 3));
        gameManager = new GameManager(player, board);
    }
}