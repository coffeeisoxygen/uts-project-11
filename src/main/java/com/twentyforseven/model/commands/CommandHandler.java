package com.twentyforseven.model.commands;

import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import com.twentyforseven.model.classes.board.IBoard;
import com.twentyforseven.model.classes.player.Player;
import com.twentyforseven.model.interfaces.PropertyChangeObservable;

public class CommandHandler implements ICommandHandler ,PropertyChangeObservable{
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
            switch (command) {
                case 'l' -> player.move(0, -1); // Move left
                case 'r' -> player.move(0, 1); // Move right
                case 'u' -> player.move(-1, -0); // Move up
                case 'd' -> player.move(1, 0); // Move down
                case 's' -> player.stay(); // Stay still
                default -> throw new IllegalArgumentException("Invalid command: " + command);
            }
            // Ensure the player stays within the board boundaries
            Point position = player.getPosition();
            if (position.x < 0 || position.x >= board.getWidth() || position.y < 0 || position.y >= board.getHeight()) {
                pcs.firePropertyChange("invalidMove", null, position);
                return; // Stop processing further commands
            }
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