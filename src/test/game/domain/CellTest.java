package game.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void copyCell() {
        Cell originCell = new Cell(true, 1, 1);
        Cell copiedCell = originCell.copyCell();

        assertEquals(originCell.getX(), copiedCell.getX());
        assertEquals(originCell.getY(), copiedCell.getY());
        assertEquals(originCell.isAlive(), copiedCell.isAlive());
    }

    @Test
    public void changeState() {
        Cell cell = new Cell(false, 0, 0);

        cell.changeState(2);
        assertFalse(cell.isAlive());

        cell.changeState(3);
        assertTrue(cell.isAlive());

        cell.setAlive(false);
        cell.changeState(4);
        assertFalse(cell.isAlive());

        cell.setAlive(true);
        cell.changeState(2);
        assertTrue(cell.isAlive());
        cell.changeState(3);
        assertTrue(cell.isAlive());

        cell.changeState(4);
        assertFalse(cell.isAlive());

        cell.setAlive(true);
        cell.changeState(1);
        assertFalse(cell.isAlive());
    }
}