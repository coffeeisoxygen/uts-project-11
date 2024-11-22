package com.twentyforseven.model.behaviors;

import java.util.Objects;

import com.twentyforseven.model.classes.player.Player;

public class BehaviorDangerPoint implements ITileBehavior {
    @Override
    public void interact(Player player) {
        player.die();
        System.out.println("TileDangerPoint.interact(Player player) called");
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
        return Objects.hash(BehaviorDangerPoint.class);
    }

}
