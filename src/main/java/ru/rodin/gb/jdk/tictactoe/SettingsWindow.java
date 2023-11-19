package ru.rodin.gb.jdk.tictactoe;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class SettingsWindow extends JFrame {
    private static int WINDOW_HEIGHT = 230;
    private static int WINDOW_WIDTH = 360;
    private static int BOARD_SIZE = 3;

    JButton btnStart = new JButton("Начать игру");

    SettingsWindow(GameWindow gameWindow) {
        setTitle("Настройки");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        setResizable(false);

        JPanel panelSettings = new JPanel(new GridLayout(9, 1));
        panelSettings.add(new JLabel("Выберите режим игры:"));

        var group = new ButtonGroup();
        var btnSingle = new JRadioButton("Одиночная игра", true);
        var btnMulti = new JRadioButton("Мультиплеер", false);
        group.add(btnSingle);
        group.add(btnMulti);
        panelSettings.add(btnSingle);
        panelSettings.add(btnMulti);
        panelSettings.add(new JLabel("Выберите размер поля"));
        panelSettings.add(new JLabel("Установленный размер поля:"));

        var sizeSlider = new JSlider(3, 10, BOARD_SIZE);
        sizeSlider.setMajorTickSpacing(1);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setPaintTicks(true);
        panelSettings.add(sizeSlider);

        panelSettings.add(new JLabel("Выберите длину для победы"));
        panelSettings.add(new JLabel("Установленная длина для победы:"));
        var sizeWinSlider = new JSlider(3, 10, BOARD_SIZE);
        sizeWinSlider.setMajorTickSpacing(1);
        sizeWinSlider.setPaintLabels(true);
        sizeWinSlider.setPaintTicks(true);
        panelSettings.add(sizeWinSlider);

        add(panelSettings);

        btnStart.addActionListener(e -> {
            gameWindow.startNewGame(0, BOARD_SIZE);
            setVisible(false);
        });
        add(btnStart, BorderLayout.SOUTH);
        pack();
    }
}
