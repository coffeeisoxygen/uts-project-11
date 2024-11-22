package com.twentyforseven.model.services;

import java.awt.Point;

import com.twentyforseven.model.classes.player.IPlayer;
import com.twentyforseven.model.classes.player.Player;
import com.twentyforseven.model.interfaces.IPlayerManager;
import com.twentyforseven.model.moveable.AbstractMoveable;

public class PlayerManager extends AbstractMoveable implements IPlayerManager {
    private IPlayer player;

    public PlayerManager(Point startPosition) {
        super(startPosition);
    }

    @Override
    public void createPlayer(String name, int score, Point startPosition) {
        this.player = new Player(name, score, startPosition);
        this.player.setPosition(startPosition); // Ensure the player's position is set to the start point
    }

    @Override
    public IPlayer getPlayer() {
        return player;
    }

    @Override
    public void movePlayerLeft() {
        player.move(-1, 0);
    }

    @Override
    public void movePlayerRight() {
        player.move(1, 0);
    }

    @Override
    public void movePlayerUp() {
        player.move(0, -1);
    }

    @Override
    public void movePlayerDown() {
        player.move(0, 1);
    }

    @Override
    public void stayPlayerStill() {
        super.stayStill(getPosition());
        player.stay();
    }

    @Override
    public void playerWin() {
        player.win();
    }

    @Override
    public void playerDie() {
        player.die();
    }

    @Override
    public Point getPosition() {
        return player.getPosition();
    }
}