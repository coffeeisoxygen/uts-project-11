package com.twentyforseven.model.services;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.twentyforseven.model.classes.board.Board;
import com.twentyforseven.model.classes.board.IBoard;
import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.interfaces.IBoardManager;

public class BoardManager implements IBoardManager {
    private IBoard board;

    @Override
    public void createMap(int rows, int cols, ITileFactory tileFactory) {
        board = new Board(rows, cols, tileFactory);
    }

    @Override
    public void placeTile(TileType type, Point position) {
        ITile tile = board.getTile(position.x, position.y);
        if (tile != null) {
            board.setTile(position.x, position.y, tile);
        }
    }

    @Override
    public void loadTemplate(String templateName) {
        // Load predefined template
    }

    @Override
    public void saveMap(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(board);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadMap(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            board = (IBoard) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printBoard() {
        board.printBoard();
    }
}