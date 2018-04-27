package game.buttons;

import game.domain.Board;
import game.listeners.ResetButtonListener;

import javax.swing.*;

public class ResetButton extends JButton {
    public ResetButton(Board board){
        setText("RESET");
        setActionCommand("ResetButtonClicked");
        addActionListener(new ResetButtonListener(board));
    }
}
