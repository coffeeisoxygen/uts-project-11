package com.twentyforseven.model.behaviors;

import java.util.Objects;

import com.twentyforseven.model.classes.player.Player;

public class BehaviorCheckponint implements ITileBehavior {
    @Override
    public void interact(Player player) {
        player.stay();
        player.addEnergy(10); // Add energy when player stays on the checkpoint
        System.out.println("TileCheckponint.interact(Player player) called");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(BehaviorCheckponint.class);
    }

}
