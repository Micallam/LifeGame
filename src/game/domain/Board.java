package game.domain;

import game.buttons.ResetButton;
import game.buttons.StartButton;
import game.listeners.BoardListener;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel{

    private Cell[][] cells;
    private int width;
    private int height;
    private int cellSize;
    private Timer timer;
    private final int DELAY;
    private StartButton startButton;
    private ResetButton resetButton;
    private BoardListener boardListener;

    public Board(int width, int height, int cellSize) {
        this.width = width;
        this.height = height;
        this.cellSize = cellSize;
        cells = new Cell[width/ cellSize][height/ cellSize];
        boardListener = new BoardListener(this);
        DELAY = 100;

        addTimer();
        addButtons();
        addMouseListener(boardListener);
        addMouseMotionListener(boardListener);

        setBackground(Color.WHITE);
        resetAll();
    }

    public void resetAll(){
        for(int i = 0; i < width/ cellSize; i++){
            for(int j = 0; j < width/ cellSize; j++){
                cells[i][j] = new Cell(false, i* cellSize, j* cellSize);
            }
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(int i = 0; i < width/ cellSize; i++){
            for(int j = 0; j < width/ cellSize; j++){
                if(cells[i][j].isAlive()) g.setColor(Color.WHITE);
                else g.setColor(Color.BLACK);

                g.fillRect(cells[i][j].getX(), cells[i][j].getY(), cellSize, cellSize);
            }
        }
    }

    public void setCellValue(int x, int y, boolean isAlive) {
        if (x >= 0 && y >= 0 && x < width/ cellSize && y < height/ cellSize) {
            cells[x][y].setAlive(isAlive);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean getCellValue(int x, int y) {
        if (x >= 0 && y >= 0 && x < width/ cellSize && y < height/ cellSize) {
            return cells[x][y].isAlive();
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void nextCycle() {
        Cell[][] newBoard = new Cell[width/ cellSize][height/ cellSize];
        copyActualBoard(newBoard);

        for (int i = 0; i < width/ cellSize; i++) {
            for (int j = 0; j < height/ cellSize; j++) {
                int neighboursCount = countAliveNeighbours(i, j);
                newBoard[i][j].changeState(neighboursCount);
            }
        }

        cells = newBoard;
        repaint();
    }

    private void copyActualBoard(Cell[][] newBoard){
        for (int i = 0; i < width/ cellSize; i++) {
            for (int j = 0; j < height/ cellSize; j++) {
                newBoard[i][j] = cells[i][j].copyCell();
            }
        }
    }

    private int countAliveNeighbours(int i, int j) {
        int startX = Math.max(i - 1, 0);
        int startY = Math.max(j - 1, 0);
        int endX = Math.min(i + 1, width/ cellSize - 1);
        int endY = Math.min(j + 1, height/ cellSize - 1);

        int aliveNeighbours = 0;
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {

                if (cells[x][y].isAlive()) {
                    aliveNeighbours++;
                }
            }
        }

        if (cells[i][j].isAlive()) {
            aliveNeighbours--;
        }

        return aliveNeighbours;
    }

    private void addButtons(){
        startButton = new StartButton(this);
        add(startButton);

        resetButton = new ResetButton(this);
        add(resetButton);
    }

    private void addTimer(){
        timer = new Timer(DELAY, boardListener);
    }

    public Timer getTimer(){
        return timer;
    }

    public StartButton getStartButton() {
        return startButton;
    }

    public ResetButton getResetButton() {
        return resetButton;
    }

    public int getCellSize(){
        return cellSize;
    }
}
