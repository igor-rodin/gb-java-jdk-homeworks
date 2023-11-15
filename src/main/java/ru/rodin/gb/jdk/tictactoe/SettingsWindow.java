package ru.rodin.gb.jdk.tictactoe;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SettingsWindow extends JFrame {
    private static int WINDOW_HEIGHT = 230;
    private static int WINDOW_WIDTH = 350;
    private static int BOARD_SIZE = 3;

    JButton btnStart = new JButton("Начать игру");

    SettingsWindow(GameWindow gameWindow) {
        setTitle("Настройки");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        setResizable(false);

        btnStart.addActionListener(e -> {
            gameWindow.startNewGame(0, BOARD_SIZE);
            setVisible(false);
        });
        add(btnStart);
    }
}
