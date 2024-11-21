package com.twentyforseven.model.classes;

import com.twentyforseven.model.behaviors.TileNormalBehavior;
import com.twentyforseven.model.enumerate.TileType;

public class TileNormaltype extends Tile {

    public TileNormaltype() {
        super(TileType.NORMALPOINT, new TileNormalBehavior());
    }

    public TileNormaltype(String name) {
        super(TileType.NORMALPOINT, name, new TileNormalBehavior());
    }

    @Override
    public void interact(Player player) {
        // Implement interaction logic here
        // For example, player.setPosition(this)
        // TODO: Implement this method
    }
}