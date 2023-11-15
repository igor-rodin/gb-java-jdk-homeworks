package ru.rodin.gb.jdk.tictactoe;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    private static int WINDOW_HEIGHT = 555;
    private static int WINDOW_WIDTH = 507;
    private static int WINDOW_X_POS = 800;
    private static int WINDOW_Y_POS = 300;

    GameWindow() {
        super("Tic-Tac-Toe");
        setBounds(WINDOW_X_POS, WINDOW_Y_POS, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}
