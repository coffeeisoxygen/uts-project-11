package com.twentyforseven.model.classes.player;

import java.awt.Point;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.twentyforseven.model.interfaces.PropertyChangeObservable;

public class Player implements IPlayer, PropertyChangeObservable {
    private static final Logger logger = Logger.getLogger(Player.class.getName());
    private String name;
    private int score;
    private Point position;
    private int energy;
    private boolean isAlive;
    private boolean hasWon;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Player(String name, int score, Point position) {
        this.name = name;
        this.score = score;
        this.position = position;
        this.energy = 100; // Default energy
        this.isAlive = true;
        this.hasWon = false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public Point getPosition() {
        return position;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        Point oldPosition = new Point(position);
        position.translate(deltaX, deltaY);
        pcs.firePropertyChange("position", oldPosition, position);
        logger.log(Level.INFO, "Moved from {0} to {1}", new Object[] { oldPosition, position });
    }

    @Override
    public void die(String reason) {
        boolean oldIsAlive = this.isAlive;
        isAlive = false;
        pcs.firePropertyChange("isAlive", oldIsAlive, isAlive);
        pcs.firePropertyChange("deathReason", null, reason);
        logger.log(Level.INFO, "Player has died: {0}", reason);
    }

    @Override
    public void increaseEnergy(int amount) {
        int oldEnergy = this.energy;
        energy += amount;
        pcs.firePropertyChange("energy", oldEnergy, energy);
        logger.log(Level.INFO, "Energy increased by {0}. Current energy: {1}", new Object[] { amount, energy });
    }

    @Override
    public void decreaseEnergy(int amount) {
        int oldEnergy = this.energy;
        energy -= amount;
        pcs.firePropertyChange("energy", oldEnergy, energy);
        logger.log(Level.INFO, "Energy decreased by {0}. Current energy: {1}", new Object[] { amount, energy });
    }

    @Override
    public void win() {
        boolean oldHasWon = this.hasWon;
        hasWon = true;
        pcs.firePropertyChange("hasWon", oldHasWon, hasWon);
        logger.info("Player has won the game!");
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public boolean hasWon() {
        return hasWon;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void stay() {
        pcs.firePropertyChange("position", position, position);
        logger.info("Player is staying on the tile.");
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", position=" + position +
                ", energy=" + energy +
                ", isAlive=" + isAlive +
                ", hasWon=" + hasWon +
                '}';
    }
}