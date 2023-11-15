package ru.rodin.gb.jdk.tictactoe;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class GameWindow extends JFrame {
    private static int WINDOW_HEIGHT = 555;
    private static int WINDOW_WIDTH = 507;
    private static int WINDOW_X_POS = 800;
    private static int WINDOW_Y_POS = 300;

    JButton btnNewGame = new JButton("Новая игра");
    JButton btnExiButton = new JButton("Закрыть");
    private Board board;

    GameWindow() {
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(WINDOW_X_POS, WINDOW_Y_POS, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);

        SettingsWindow settingsWindow = new SettingsWindow(this);
        JPanel panelBottom = new JPanel(new GridLayout(1, 2));

        btnNewGame.addActionListener(e -> {
            settingsWindow.setVisible(true);
        });

        btnExiButton.addActionListener(e -> {
            System.exit(0);
        });

        panelBottom.add(btnNewGame);
        panelBottom.add(btnExiButton);
        board = new Board();
        add(board);
        add(panelBottom, BorderLayout.SOUTH);
        setVisible(true);
        update(getGraphics());
    }

    public void startNewGame(int gameMode, int BoardSize) {
        board.startNewGame(gameMode, BoardSize);
    }
}
