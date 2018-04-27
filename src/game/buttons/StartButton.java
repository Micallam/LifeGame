package game.buttons;

import javax.swing.*;
import game.listeners.StartButtonListener;
import game.domain.Board;

public class StartButton extends JButton {
    public StartButton(Board board){
        setText("START");
        setActionCommand("StartButtonClicked");
        addActionListener(new StartButtonListener(board));
    }
}
