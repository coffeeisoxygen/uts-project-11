package com.twentyforseven.util;

import com.twentyforseven.model.algorithms.IMapCreationAlgorithm;
import com.twentyforseven.model.algorithms.MazeGenerator;
import com.twentyforseven.model.classes.board.Board;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import com.twentyforseven.model.interfaces.IBoard;

public class GameContext {
    private static GameContext instance;
    private IBoard board;
    private ITileFactory tileFactory;
    private IMapCreationAlgorithm mazeGenerator;
    private IMapCreationAlgorithm randomizeMapAlgorithm;

    private GameContext() {
        tileFactory = new TileFactoryImpl();
        board = new Board(6, 12, tileFactory);
        mazeGenerator = new MazeGenerator(tileFactory);
        randomizeMapAlgorithm = new MazeGenerator(tileFactory);
    }

    public static synchronized GameContext getInstance() {
        if (instance == null) {
            instance = new GameContext();
        }
        return instance;
    }

    public IBoard getBoard() {
        return board;
    }

    public ITileFactory getTileFactory() {
        return tileFactory;
    }

    public IMapCreationAlgorithm getMazeGenerator() {
        return mazeGenerator;
    }

    public IMapCreationAlgorithm getRandomizeMapAlgorithm() {
        return randomizeMapAlgorithm;
    }
}