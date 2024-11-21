// package com.twentyforseven.model.classes;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;
// import java.awt.Color;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import com.twentyforseven.model.behaviors.ITileBehavior;
// import com.twentyforseven.model.enumerate.TileType;

// public class TileTest {

// private ITileBehavior mockBehavior;
// private Tile tile;

// @BeforeEach
// public void setUp() {
// mockBehavior = mock(ITileBehavior.class);
// tile = new ConcreteTile(TileType.CHECKPOINT, mockBehavior);
// }

// @Test
// public void testTileInitialization() {
// assertEquals(TileType.CHECKPOINT, tile.getType());
// assertEquals("CHECKPOINT", tile.getName());
// assertEquals(Color.GREEN, tile.getColor());
// }

// @Test
// public void testSetType() {
// tile.setType(TileType.FINISHPOINT);
// assertEquals(TileType.FINISHPOINT, tile.getType());
// assertEquals(Color.RED, tile.getColor());
// }

// @Test
// public void testSetName() {
// tile.setName("NewName");
// assertEquals("NewName", tile.getName());
// }

// @Test
// public void testSetColor() {
// tile.setColor(Color.BLACK);
// assertEquals(Color.BLACK, tile.getColor());
// }

// @Test
// public void testDefaultColor() {
// assertEquals(Color.GREEN, Tile.getDefaultColor(TileType.CHECKPOINT));
// assertEquals(Color.BLUE, Tile.getDefaultColor(TileType.STARTPOINT));
// assertEquals(Color.RED, Tile.getDefaultColor(TileType.FINISHPOINT));
// assertEquals(Color.YELLOW, Tile.getDefaultColor(TileType.DANGERPOINT));
// assertEquals(Color.WHITE, Tile.getDefaultColor(TileType.NORMALPOINT));
// }

// @Test
// public void testInteract() {
// Player mockPlayer = mock(Player.class);
// tile.interact(mockPlayer);
// verify(mockBehavior).interact(mockPlayer);
// }

// @Test
// public void testEqualsAndHashCode() {
// Tile anotherTile = new ConcreteTile(TileType.CHECKPOINT, mockBehavior);
// assertEquals(tile, anotherTile);
// assertEquals(tile.hashCode(), anotherTile.hashCode());
// }

// @Test
// public void testToString() {
// String expected = "Tile{name='CHECKPOINT', type=CHECKPOINT,
// color=java.awt.Color[r=0,g=255,b=0]}";
// assertEquals(expected, tile.toString());
// }

// // ConcreteTile class for testing purposes
// private static class ConcreteTile extends Tile {
// public ConcreteTile(TileType type, ITileBehavior behavior) {
// super(type, behavior);
// }
// }
// }