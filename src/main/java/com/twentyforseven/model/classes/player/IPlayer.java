/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.twentyforseven.model.classes.player;

import java.awt.Point;
import java.beans.PropertyChangeListener;

/**
 *
 * @author YOGA
 */
public interface IPlayer {

    String getName();

    void setName(String name);

    int getScore();

    void setScore(int score);

    Point getPosition();

    void setPosition(Point position);

    void move(int deltaX, int deltaY);

    void die();

    void addEnergy(int amount);

    void win();

    boolean isAlive();

    boolean hasWon();

    int getEnergy();

    void stay();

    @Override
    String toString();

    void addPropertyChangeListener(PropertyChangeListener listener);

}
