package com.twentyforseven.model.classes.player;

import java.awt.Point;

public class Player {
    private String name;
    private int score;
    private Point position;

    public Player(String name, int score, Point position) {
        this.name = name;
        this.score = score;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void move(int deltaX, int deltaY) {
        position.translate(deltaX, deltaY);
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