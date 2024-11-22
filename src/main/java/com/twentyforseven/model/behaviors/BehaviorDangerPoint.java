package com.twentyforseven.model.behaviors;

import java.util.Objects;
import java.util.logging.Logger;

import com.twentyforseven.model.classes.player.Player;

public class BehaviorDangerPoint implements ITileBehavior {
    private static final String DEATH_REASON = "Died:Lost In Danger Point";
    private static final Logger LOGGER = Logger.getLogger(BehaviorDangerPoint.class.getName());

    @Override
    public void interact(Player player) {
        player.die(DEATH_REASON);
        LOGGER.info("TileDangerPoint.interact(Player player) called");
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        // All instances of BehaviorDangerPoint are considered equal
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(BehaviorDangerPoint.class);
    }

}
