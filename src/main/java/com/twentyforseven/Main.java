package com.twentyforseven;

import com.twentyforseven.model.services.GameManager;
import com.twentyforseven.util.GameContext;

public class Main {
    public static void main(String[] args) {
        // Initialize the game context
        GameContext context = GameContext.getInstance();
        GameManager gameManager = context.getGameManager();

        // Process user input commands
        String commands = "lrurddddssss";
        gameManager.startGame(commands);

        // Print the final state of the board
        gameManager.getBoard().printBoard();
    }
}