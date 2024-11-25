package com.twentyforseven.model.behaviors;

import java.util.Objects;

import com.twentyforseven.model.classes.player.Player;

public class BehaviorStartPoint implements ITileBehavior {
    @Override
    public void interact(Player player) {
        System.out.println("Welcome to the game!");
        System.out.println("TileStartPoint.interact(Player player) called");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        // All instances of BehaviorStartPoint are considered equal
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(BehaviorStartPoint.class);
    }
}
