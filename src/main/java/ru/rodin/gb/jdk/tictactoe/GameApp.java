package ru.rodin.gb.jdk.tictactoe;

import java.awt.EventQueue;

public class GameApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new GameWindow();
        });

    }
}
