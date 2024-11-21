// package com.twentyforseven.model.classes;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import com.twentyforseven.model.enumerate.TileType;
// import com.twentyforseven.model.factory.ITileFactory;
// import com.twentyforseven.model.interfaces.ITile;

// public class BoardTest {

// private ITileFactory tileFactory;
// private ITile tile;
// private Board board;

// @BeforeEach
// public void setUp() {
// tileFactory = mock(ITileFactory.class);
// tile = mock(ITile.class);
// when(tileFactory.createTile(TileType.NORMALPOINT)).thenReturn(tile);
// when(tile.getName()).thenReturn("NORMALPOINT");
// board = new Board(3, 3, tileFactory);
// }

// @Test
// public void testInitializeBoard() {
// for (int i = 0; i < 3; i++) {
// for (int j = 0; j < 3; j++) {
// assertEquals(tile, board.getTile(i, j));
// }
// }
// verify(tileFactory, times(9)).createTile(TileType.NORMALPOINT);
// }

// @Test
// public void testGetTile() {
// ITile retrievedTile = board.getTile(0, 0);
// assertNotNull(retrievedTile);
// assertEquals(tile, retrievedTile);
// }

// @Test
// public void testSetTile() {
// ITile newTile = mock(ITile.class);
// board.setTile(0, 0, newTile);
// assertEquals(newTile, board.getTile(0, 0));
// }

// @Test
// public void testPrintBoard() {
// board.printBoard();
// verify(tile, times(9)).getName();
// }
// }