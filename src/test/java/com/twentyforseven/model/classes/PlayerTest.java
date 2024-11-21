package com.twentyforseven.model.classes;

import java.awt.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class PlayerTest {

    @Test
    public void testPlayerConstructor() {
        Point position = new Point(0, 0);
        Player player = new Player("John", 100, position);
        assertEquals("John", player.getName());
        assertEquals(100, player.getScore());
        assertEquals(position, player.getPosition());
    }

    @Test
    public void testGetName() {
        Player player = new Player("John", 100, new Point(0, 0));
        assertEquals("John", player.getName());
    }

    @Test
    public void testSetName() {
        Player player = new Player("John", 100, new Point(0, 0));
        player.setName("Doe");
        assertEquals("Doe", player.getName());
    }

    @Test
    public void testGetScore() {
        Player player = new Player("John", 100, new Point(0, 0));
        assertEquals(100, player.getScore());
    }

    @Test
    public void testSetScore() {
        Player player = new Player("John", 100, new Point(0, 0));
        player.setScore(200);
        assertEquals(200, player.getScore());
    }

    @Test
    public void testGetPosition() {
        Point position = new Point(0, 0);
        Player player = new Player("John", 100, position);
        assertEquals(position, player.getPosition());
    }

    @Test
    public void testSetPosition() {
        Point position = new Point(0, 0);
        Player player = new Player("John", 100, position);
        Point newPosition = new Point(10, 10);
        player.setPosition(newPosition);
        assertEquals(newPosition, player.getPosition());
    }

    @Test
    public void testMove() {
        Point position = new Point(0, 0);
        Player player = new Player("John", 100, position);
        player.move(5, 5);
        assertEquals(new Point(5, 5), player.getPosition());
    }

    @Test
    public void testToString() {
        Point position = new Point(0, 0);
        Player player = new Player("John", 100, position);
        String expected = "Player{name='John', score=100, position=java.awt.Point[x=0,y=0]}";
        assertEquals(expected, player.toString());
    }
}