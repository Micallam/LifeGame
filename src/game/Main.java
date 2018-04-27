package game;

import game.domain.Board;
import game.frame.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Life");
        Board board = new Board(500, 500, 10);

        MainFrame mainFrame = new MainFrame();
        mainFrame.setFrame(frame, board);
    }
}
