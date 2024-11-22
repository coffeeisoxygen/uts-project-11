package com.twentyforseven.model.commands;

import com.twentyforseven.model.interfaces.IBoardManager;

public class SaveMapCommand implements Command {
    private IBoardManager boardManager;
    private String fileName;

    public SaveMapCommand(IBoardManager boardManager, String fileName) {
        this.boardManager = boardManager;
        this.fileName = fileName;
    }

    @Override
    public void execute() {
        boardManager.saveMap(fileName);
    }
}
