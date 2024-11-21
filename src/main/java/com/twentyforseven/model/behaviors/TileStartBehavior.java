package com.twentyforseven.model.behaviors;

import java.util.Objects;

import com.twentyforseven.model.classes.Player;

public class TileStartBehavior implements ITileBehavior {
    @Override
    public void interact(Player player) {
        // TODO: Implement this method
        System.out.println("TileStartPoint.interact(Player player) called");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        // All instances of TileNormalBehavior are considered equal
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(TileNormalBehavior.class);
    }
}
