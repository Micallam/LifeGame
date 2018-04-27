package game.listeners;

import game.domain.Board;

import java.awt.event.*;

public class BoardListener implements ActionListener, MouseListener, MouseMotionListener {
    private Board board;
    private boolean isMouseInsideBoard;

    public BoardListener(Board board){
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        board.nextCycle();
    }
    @Override
    public void mouseClicked(MouseEvent e){
        if (isMouseInsideBoard){
            if(!board.getCellValue(e.getX()/board.getCellSize(),e.getY()/board.getCellSize())){
                board.setCellValue(e.getX()/board.getCellSize(), e.getY()/board.getCellSize(), true);
                board.repaint();
            }else {
                board.setCellValue(e.getX()/board.getCellSize(), e.getY()/board.getCellSize(), false);
                board.repaint();
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseReleased(MouseEvent e){

    }
    @Override
    public void mouseEntered(MouseEvent e){
        isMouseInsideBoard = true;
    }
    @Override
    public void mouseExited(MouseEvent e){
        isMouseInsideBoard = false;
    }

    @Override
    public void mouseDragged(MouseEvent e){
        if(isMouseInsideBoard){
            board.setCellValue(e.getX()/board.getCellSize(), e.getY()/board.getCellSize(), true);
            board.repaint();
        }
    }
    @Override
    public void mouseMoved(MouseEvent e){

    }
}
