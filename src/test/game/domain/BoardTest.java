package game.domain;

import org.junit.Test;
import static org.junit.Assert.*;
import game.domain.Board;

public class BoardTest {
    @Test
    public void testBoardCreate(){
        Board board = new Board(100, 100, 1);
        assertNotNull(board);
    }

    @Test
    public void testBoardValues(){
        Board board = new Board(100, 100, 1);
        assertEquals(100, board.getWidth());
        assertEquals(100, board.getHeight());
        assertNotNull(board.getCells());
    }
    @Test
    public void testResetAll(){
        int width = 100;
        int height = 100;
        int cellSize = 10;

        Board board = new Board(width, height, cellSize);
        int xCellCount = width/cellSize;
        int yCellCount = height/cellSize;

        for (int i=0; i<xCellCount; i++){
            for (int j=0; j<yCellCount; j++){
                assertEquals(false, board.getCellValue(i, j));
            }
        }
    }

    @Test
    public void testSetAndGetCellValue(){
        Board board = new Board(5, 5, 1);
        assertFalse(board.getCellValue(2, 2));
        board.setCellValue(2, 2, true);
        assertTrue(board.getCellValue(2, 2));

        assertFalse(board.getCellValue(0, 0));
        board.setCellValue(0, 0, true);
        assertTrue(board.getCellValue(0, 0));
    }

    @Test
    public void testCountAliveNeighbours(){
        Board board = new Board(5, 5, 1);

        assertEquals(0, board.countAliveNeighbours(0, 0));

        board.setCellValue(1, 1, true);
        assertEquals(1, board.countAliveNeighbours(0, 0));

        board.setCellValue(0, 0, true);
        assertEquals(1, board.countAliveNeighbours(0, 0));

        board.setCellValue(0, 1, true);
        assertEquals(2, board.countAliveNeighbours(0, 0));
    }
}