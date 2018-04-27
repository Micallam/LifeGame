package game.listeners;

import game.domain.Board;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import game.buttons.StartButton;

public class StartButtonListener implements ActionListener{
    private Board board;
    public StartButtonListener(Board board){
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();
        StartButton button = board.getStartButton();

        if (action.equals("StartButtonClicked")){
            button.setText("STOP");
            button.setActionCommand("StopButtonClicked");
            board.getTimer().start();
        }else if (action.equals("StopButtonClicked")){
            button.setText("START");
            button.setActionCommand("StartButtonClicked");
            board.getTimer().stop();
        }
    }
}
