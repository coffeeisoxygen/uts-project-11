package com.twentyforseven.model.behaviors;

import java.util.Objects;

import com.twentyforseven.model.classes.player.Player;

public class BehaviorNormalPoint implements ITileBehavior {
    @Override
    public void interact(Player player) {
        System.out.println("TileNormalBehavior.interact(Player player) called");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(BehaviorNormalPoint.class);
    }
}
