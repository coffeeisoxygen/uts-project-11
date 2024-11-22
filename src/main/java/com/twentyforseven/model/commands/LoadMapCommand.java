package com.twentyforseven.model.commands;

import com.twentyforseven.model.interfaces.IBoardManager;

public class LoadMapCommand implements Command {
    private IBoardManager boardManager;
    private String fileName;

    public LoadMapCommand(IBoardManager boardManager, String fileName) {
        this.boardManager = boardManager;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        boardManager.loadMap(fileName);
    }
}
