package com.twentyforseven.model.behaviors;

import com.twentyforseven.model.classes.Player;

public class TileNormalBehavior implements ITileBehavior {
    @Override
    public void interact(Player player) {
        // Implement interaction logic here
        // For example, player.setPosition(this)
        // TODO: Implement this method
        System.out.println("Player " + player.getName() + " interacted with a normal tile.");
    }
}