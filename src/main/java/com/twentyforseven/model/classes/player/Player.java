package com.twentyforseven.model.classes.player;

import java.awt.Point;

import com.twentyforseven.model.interfaces.IPlayer;

public class Player implements IPlayer {
    private String name;
    private int score;
    private Point position;
    private int energy;
    private boolean isAlive;
    private boolean hasWon;

    public Player(String name, int score, Point position) {
        this.name = name;
        this.score = score;
        this.position = position;
        this.energy = 100; // Default energy
        this.isAlive = true;
        this.hasWon = false;
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
        position.translate(deltaX, deltaY);
    }

    @Override
    public void die() {
        isAlive = false;
        System.out.println("Player has died.");
    }

    @Override
    public void addEnergy(int amount) {
        energy += amount;
        System.out.println("Player's energy increased by " + amount + ". Current energy: " + energy);
    }

    @Override
    public void win() {
        hasWon = true;
        System.out.println("Player has won the game!");
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
        System.out.println("Player is staying on the tile.");
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", position=" + position +
                '}';
    }
}