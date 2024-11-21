package com.twentyforseven;
import com.twentyforseven.model.classes.Board;
import com.twentyforseven.model.factory.ITileFactory;
import com.twentyforseven.model.factory.TileFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class MainTest {

    private ITileFactory tileFactory;
    private Board board;

    @BeforeEach
    public void setUp() {
        tileFactory = new TileFactoryImpl();
        board = new Board(10, 10, tileFactory);
    }

    @Test
    public void testBoardInitialization() {
        assertNotNull(board);
    }

    @Test
    public void testGetTile() {
        assertNotNull(board.getTile(0, 0));
    }

    @Test
    public void testBoardDimensions() {
        assertEquals(10, board.getWidth());
        assertEquals(10, board.getHeight());
    }
}