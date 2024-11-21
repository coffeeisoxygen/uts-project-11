package com.twentyforseven.model.classes;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.twentyforseven.model.enumerate.TileType;

public class TileTest {

    private Tile checkpointTile;
    private Tile startpointTile;
    private Tile finishpointTile;
    private Tile dangerpointTile;
    private Tile normalpointTile;

    @BeforeEach
    public void setUp() {
        checkpointTile = new Tile(TileType.CHECKPOINT) {
        };
        startpointTile = new Tile(TileType.STARTPOINT, "Start") {
        };
        finishpointTile = new Tile(TileType.FINISHPOINT) {
        };
        dangerpointTile = new Tile(TileType.DANGERPOINT, "Danger") {
        };
        normalpointTile = new Tile(TileType.NORMALPOINT) {
        };
    }

    @Test
    public void testTileType() {
        assertEquals(TileType.CHECKPOINT, checkpointTile.getType());
        assertEquals(TileType.STARTPOINT, startpointTile.getType());
        assertEquals(TileType.FINISHPOINT, finishpointTile.getType());
        assertEquals(TileType.DANGERPOINT, dangerpointTile.getType());
        assertEquals(TileType.NORMALPOINT, normalpointTile.getType());
    }

    @Test
    public void testTileColor() {
        assertEquals(Color.GREEN, checkpointTile.getColor());
        assertEquals(Color.BLUE, startpointTile.getColor());
        assertEquals(Color.RED, finishpointTile.getColor());
        assertEquals(Color.YELLOW, dangerpointTile.getColor());
        assertEquals(Color.WHITE, normalpointTile.getColor());
    }

    @Test
    public void testTileName() {
        assertEquals(TileType.CHECKPOINT.toString(), checkpointTile.getName());
        assertEquals("Start", startpointTile.getName());
        assertEquals(TileType.FINISHPOINT.toString(), finishpointTile.getName());
        assertEquals("Danger", dangerpointTile.getName());
        assertEquals(TileType.NORMALPOINT.toString(), normalpointTile.getName());
    }

    @Test
    public void testSetColor() {
        Color newColor = Color.MAGENTA;
        checkpointTile.setColor(newColor);
        assertEquals(newColor, checkpointTile.getColor());
    }

    @Test
    public void testSetName() {
        String newName = "NewName";
        checkpointTile.setName(newName);
        assertEquals(newName, checkpointTile.getName());
    }

    @Test
    public void testSetType() {
        TileType newType = TileType.DANGERPOINT;
        checkpointTile.setType(newType);
        assertEquals(newType, checkpointTile.getType());
    }

    @Test
    public void testGetDefaultColor() {
        assertEquals(Color.GREEN, Tile.getDefaultColor(TileType.CHECKPOINT));
        assertEquals(Color.BLUE, Tile.getDefaultColor(TileType.STARTPOINT));
        assertEquals(Color.RED, Tile.getDefaultColor(TileType.FINISHPOINT));
        assertEquals(Color.YELLOW, Tile.getDefaultColor(TileType.DANGERPOINT));
        assertEquals(Color.WHITE, Tile.getDefaultColor(TileType.NORMALPOINT));
    }
}