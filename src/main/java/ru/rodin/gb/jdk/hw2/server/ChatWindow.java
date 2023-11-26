package ru.rodin.gb.jdk.hw2.server;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChatWindow extends JFrame implements ServerListener {
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 200;
    private static final int WINDOW_POS_X = 800;
    private static final int WINDOW_POS_Y = 600;

    private final JButton startButton = new JButton("Старт");
    private final JButton stopButton = new JButton("Стоп");

    private final ChatServer chatServer = new ChatServer(this);
    private StringBuilder log = new StringBuilder();

    public ChatWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Chat");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        createComponents();

        startButton.addActionListener(e -> {
            chatServer.start();
        });

        stopButton.addActionListener(e -> {
            chatServer.stop();
        });
    }

    @Override
    public void msgReceived(String msg) {
        logMsg(msg);
    }

    private void createComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(startButton);
        panel.add(stopButton);
        add(panel);
        pack();
        setVisible(true);
    }

    private void logMsg(String msg) {
        log.append(msg).append("\n");
        System.out.println(msg);
    }

    private String getLog() {
        return log.toString();
    }
}
