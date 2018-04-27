package game.frame;

import game.domain.Board;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    public void setFrame(JFrame frame, Board board){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(board);
        frame.setPreferredSize(new Dimension(516, 539));
        frame.pack();
        frame.setVisible(true);
    }
}
