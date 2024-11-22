
package com.twentyforseven.model.classes;

import java.awt.Color;
import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.twentyforseven.model.behaviors.ITileBehavior;
import com.twentyforseven.model.classes.player.Player;
import com.twentyforseven.model.classes.tile.Tile;
import com.twentyforseven.model.enumerate.TileType;


public class TileTest {

    private ITileBehavior mockBehavior;
    private Point position;

    @BeforeEach
    public void setUp() {
        mockBehavior = mock(ITileBehavior.class);
        position = new Point(0, 0);
    }

    @Test
    public void testTileConstructorWithTypeBehaviorAndPosition() {
        Tile tile = new ConcreteTile(TileType.CHECKPOINT, mockBehavior, position);
        assertEquals(TileType.CHECKPOINT, tile.getType());
        assertEquals("CHECKPOINT", tile.getName());
        assertEquals(Color.GREEN, tile.getColor());
        assertEquals(position, tile.getPosition());
    }

    @Test
    public void testTileConstructorWithTypeNameBehaviorAndPosition() {
        Tile tile = new ConcreteTile(TileType.STARTPOINT, "Start", mockBehavior, position);
        assertEquals(TileType.STARTPOINT, tile.getType());
        assertEquals("Start", tile.getName());
        assertEquals(Color.BLUE, tile.getColor());
        assertEquals(position, tile.getPosition());
    }

    @Test
    public void testSetType() {
        Tile tile = new ConcreteTile(TileType.CHECKPOINT, mockBehavior, position);
        tile.setType(TileType.FINISHPOINT);
        assertEquals(TileType.FINISHPOINT, tile.getType());
        assertEquals(Color.RED, tile.getColor());
    }

    @Test
    public void testSetName() {
        Tile tile = new ConcreteTile(TileType.CHECKPOINT, mockBehavior, position);
        tile.setName("NewName");
        assertEquals("NewName", tile.getName());
    }

    @Test
    public void testSetColor() {
        Tile tile = new ConcreteTile(TileType.CHECKPOINT, mockBehavior, position);
        tile.setColor(Color.BLACK);
        assertEquals(Color.BLACK, tile.getColor());
    }

    @Test
    public void testSetPosition() {
        Tile tile = new ConcreteTile(TileType.CHECKPOINT, mockBehavior, position);
        Point newPosition = new Point(1, 1);
        tile.setPosition(newPosition);
        assertEquals(newPosition, tile.getPosition());
    }

    @Test
    public void testInteract() {
        Tile tile = new ConcreteTile(TileType.CHECKPOINT, mockBehavior, position);
        Player mockPlayer = mock(Player.class);
        tile.interact(mockPlayer);
        verify(mockBehavior).interact(mockPlayer);
    }

    @Test
    public void testEqualsAndHashCode() {
        Tile tile1 = new ConcreteTile(TileType.CHECKPOINT, mockBehavior, position);
        Tile tile2 = new ConcreteTile(TileType.CHECKPOINT, mockBehavior, position);
        assertEquals(tile1, tile2);
        assertEquals(tile1.hashCode(), tile2.hashCode());
    }

    private static class ConcreteTile extends Tile {
        public ConcreteTile(TileType type, ITileBehavior behavior, Point position) {
            super(type, behavior, position);
        }

        public ConcreteTile(TileType type, String name, ITileBehavior behavior, Point position) {
            super(type, name, behavior, position);
        }
    }
}