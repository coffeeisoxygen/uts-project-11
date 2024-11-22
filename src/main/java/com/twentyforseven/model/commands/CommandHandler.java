package com.twentyforseven.model.commands;

import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.twentyforseven.model.classes.board.IBoard;
import com.twentyforseven.model.classes.player.Player;
import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.interfaces.PropertyChangeObservable;

public class CommandHandler implements ICommandHandler, PropertyChangeObservable {
    private Player player;
    private IBoard board;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public CommandHandler(Player player, IBoard board) {
        this.player = player;
        this.board = board;
    }

    @Override
    public void processCommands(String commands) {
        for (char command : commands.toLowerCase().toCharArray()) {
            if (!player.isAlive()) {
                return; // Stop processing if the player is dead
            }

            switch (command) {
                case 'l' -> player.move(0, -1); // Move left
                case 'r' -> player.move(0, 1); // Move right
                case 'u' -> player.move(-1, -0); // Move up
                case 'd' -> player.move(1, 0); // Move down
                case 's' -> player.stay(); // Stay still/ Stay still
                default -> throw new IllegalArgumentException("Invalid command: " + command);
            }

            // Decrease energy for each move
            player.decreaseEnergy(1);

            // Ensure the player stays within the board boundaries
            Point position = player.getPosition();
            if (position.x < 0 || position.x >= board.getWidth() || position.y < 0 || position.y >= board.getHeight()) {
                player.die("Died:Fall From Cliff");
                pcs.firePropertyChange("invalidMove", null, position);
                return; // Stop processing further commands
            }

            // Check for tile interactions
            ITile tile = board.getTile(position.x, position.y);
            if (tile != null) {
                tile.interact(player);
            }

            // Check for dying conditions
            if (player.getEnergy() <= 0) {
                player.die("Died:Exhausted and Starving");
                return;
            }
        }

        // Check if the player has reached the finish point
        ITile finishTile = board.getTile(board.getHeight() - 1, board.getWidth() - 1);
        if (player.getPosition().equals(finishTile.getPosition())) {
            player.win();
        } else {
            player.die("Died: Lost In Hiking");
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }
}