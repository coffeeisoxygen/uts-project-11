package com.twentyforseven.model.moveable;

import java.awt.Point;

public interface IMoveable {
    void moveLeft(Point point);

    void moveRight(Point point);

    void moveUp(Point point);

    void moveDown(Point point);

    void stayStill(Point point);

}
