package test.java.board;

import main.board.Grid;
import main.space.Position;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridTest {
    private final static Grid grid = new Grid(5,5);

    @Test
    public void testNotValidPositionInGrid() {
        assertTrue(grid.isNotValidPosition(new Position(-1,5)));
    }

    @Test
    public void testValidPositionInGrid() {
        assertFalse(grid.isNotValidPosition(new Position(0,0)));
    }
}
