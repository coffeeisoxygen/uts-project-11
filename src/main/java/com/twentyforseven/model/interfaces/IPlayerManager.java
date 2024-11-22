package com.twentyforseven.model.interfaces;

import java.awt.Point;

import com.twentyforseven.model.classes.player.IPlayer;

public interface IPlayerManager {
    void createPlayer(String name, int score, Point startPosition);

    IPlayer getPlayer();

    Point getPosition();

    void movePlayerLeft();

    void movePlayerRight();

    void movePlayerUp();

    void movePlayerDown();

    void stayPlayerStill();

    void playerWin();

    void playerDie();
}