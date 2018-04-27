package game.listeners;

import game.domain.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetButtonListener implements ActionListener{
    private Board board;
    public ResetButtonListener(Board board){
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (board.getResetButton().getActionCommand().equals("ResetButtonClicked")) board.resetAll();
    }
}
