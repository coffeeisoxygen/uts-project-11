package com.twentyforseven.model.classes;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.twentyforseven.model.classes.board.Board;
import com.twentyforseven.model.classes.tile.ITile;
import com.twentyforseven.model.enumerate.TileType;
import com.twentyforseven.model.factory.ITileFactory;

public class BoardTest {

    private ITileFactory tileFactory;
    private ITile tile;
    private Board board;

    @BeforeEach
    public void setUp() {
        tileFactory = mock(ITileFactory.class);
        tile = mock(ITile.class);
        when(tileFactory.createTile(eq(TileType.NORMALPOINT), any(Point.class))).thenReturn(tile);
        when(tile.getType()).thenReturn(TileType.NORMALPOINT);
        board = new Board(3, 3, tileFactory);
    }

    @Test
    public void testInitializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(tile, board.getTile(i, j));
            }
        }
    }

    @Test
    public void testGetTile() {
        assertEquals(tile, board.getTile(0, 0));
    }

    @Test
    public void testSetTile() {
        ITile newTile = mock(ITile.class);
        board.setTile(0, 0, newTile);
        assertEquals(newTile, board.getTile(0, 0));
    }

    @Test
    public void testGetWidth() {
        assertEquals(3, board.getWidth());
    }

    @Test
    public void testGetHeight() {
        assertEquals(3, board.getHeight());
    }

}