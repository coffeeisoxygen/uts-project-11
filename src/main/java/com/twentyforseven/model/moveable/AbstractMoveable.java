package com.twentyforseven.model.moveable;

import java.awt.Point;

public abstract class AbstractMoveable implements IMoveable {

    protected AbstractMoveable(Point startPosition) {
        // Constructor can be kept for potential future use
    }

    @Override
    public void moveLeft(Point point) {
        point.translate(-1, 0);
        System.out.println("Moved left to: " + point);
    }

    @Override
    public void moveRight(Point point) {
        point.translate(1, 0);
        System.out.println("Moved right to: " + point);
    }

    @Override
    public void moveUp(Point point) {
        point.translate(0, -1);
        System.out.println("Moved up to: " + point);
    }

    @Override
    public void moveDown(Point point) {
        point.translate(0, 1);
        System.out.println("Moved down to: " + point);
    }

    @Override
    public void stayStill(Point point) {
        System.out.println("Staying still at: " + point);
    }
}