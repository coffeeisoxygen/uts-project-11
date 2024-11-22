package com.twentyforseven.model.services;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.twentyforseven.model.classes.player.IPlayer;

public class PlayerManagerTest {
    private PlayerManager playerManager;
    private Point startPosition;

    @BeforeEach
    public void setUp() {
        startPosition = new Point(0, 0);
        playerManager = new PlayerManager(startPosition);
        playerManager.createPlayer("TestPlayer", 0, startPosition);
    }

    @Test
    public void testPlayerCreation() {
        IPlayer player = playerManager.getPlayer();
        assertNotNull(player);
        assertEquals("TestPlayer", player.getName());
        assertEquals(0, player.getScore());
        assertEquals(startPosition, player.getPosition());
    }

    @Test
    public void testMovePlayerRight() {
        playerManager.movePlayerRight();
        assertEquals(new Point(1, 0), playerManager.getPosition());
    }

    @Test
    public void testMovePlayerLeft() {
        playerManager.movePlayerLeft();
        assertEquals(new Point(-1, 0), playerManager.getPosition());
    }

    @Test
    public void testMovePlayerUp() {
        playerManager.movePlayerUp();
        assertEquals(new Point(0, -1), playerManager.getPosition());
    }

    @Test
    public void testMovePlayerDown() {
        playerManager.movePlayerDown();
        assertEquals(new Point(0, 1), playerManager.getPosition());
    }

    @Test
    public void testPlayerWin() {
        playerManager.playerWin();
        assertTrue(playerManager.getPlayer().hasWon());
    }

    @Test
    public void testPlayerDie() {
        playerManager.playerDie();
        assertFalse(playerManager.getPlayer().isAlive());
    }
}