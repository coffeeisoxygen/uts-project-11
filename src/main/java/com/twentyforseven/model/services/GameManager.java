package com.twentyforseven.model.services;

import com.twentyforseven.model.classes.board.IBoard;
import com.twentyforseven.model.classes.player.Player;
import com.twentyforseven.model.commands.CommandHandler;
import com.twentyforseven.model.commands.ICommandHandler;

public class GameManager {
    private Player player;
    private IBoard board;
    private ICommandHandler commandHandler;

    public GameManager(Player player, IBoard board) {
        this.player = player;
        this.board = board;
        this.commandHandler = new CommandHandler(player, board);
    }

    public void startGame(String commands) {
        commandHandler.processCommands(commands);
    }

    public Player getPlayer() {
        return player;
    }

    public IBoard getBoard() {
        return board;
    }

    public ICommandHandler getCommandHandler() {
        return commandHandler;
    }
}