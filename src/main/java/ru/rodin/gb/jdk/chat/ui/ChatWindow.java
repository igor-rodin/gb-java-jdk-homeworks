package ru.rodin.gb.jdk.chat.ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ru.rodin.gb.jdk.chat.logger.ChatLogger;

public class ChatWindow extends JFrame {
    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_POS_X = 800;
    private static final int WINDOW_POS_Y = 400;

    private static final String WINDOW_TITLE = "Chat client";
    private static final String DEFAULT_IP = "127.0.0.1";
    private static final String DEFAULT_PORT = "8189";
    private static final String LOGIN_BTN_TEXT = "Войти";
    private static final String LOGOUT_BTN_TEXT = "Выйти";
    private static final String SEND_BTN_TEXT = "Отправить";

    private JTextField ipField = new JTextField(DEFAULT_IP);
    private JTextField portField = new JTextField(DEFAULT_PORT);
    private JTextField loginField = new JTextField("login");
    private JTextField passwordField = new JPasswordField("пароль");
    private JTextField messageField = new JTextField();
    private JButton connectButton = new JButton(LOGIN_BTN_TEXT);
    private JButton logoutButton = new JButton(LOGOUT_BTN_TEXT);
    private JButton sendButton = new JButton(SEND_BTN_TEXT);
    private JTextArea chatLog = new JTextArea();
    private String user;

    public ChatWindow() {
        setTitle(WINDOW_TITLE);
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);
        initWidgets();
        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        connectButton.addActionListener(e -> {
            loadLog();
            login();
        });

        logoutButton.addActionListener(e -> {
            logout();
        });

        sendButton.addActionListener(e -> {
            sendMessage();
        });

        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (!user.isEmpty()) {
                    logout();
                }
            }
        });
    }

    private void initWidgets() {
        JPanel serverPanel = new JPanel(new GridLayout(3, 2));
        logoutButton.setEnabled(false);
        sendButton.setEnabled(false);

        serverPanel.add(ipField);
        serverPanel.add(portField);
        serverPanel.add(loginField);
        serverPanel.add(passwordField);
        serverPanel.add(connectButton);
        serverPanel.add(logoutButton);
        add(serverPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(chatLog);
        chatLog.setEditable(false);
        add(scrollPane, BorderLayout.CENTER);

        JPanel messagPanel = new JPanel(new BorderLayout());
        messagPanel.add(messageField, BorderLayout.CENTER);
        messagPanel.add(sendButton, BorderLayout.EAST);
        add(messagPanel, BorderLayout.SOUTH);
    }

    private void sendMessage() {
        String message = messageField.getText();
        messageField.setText("");
        if (!message.isEmpty()) {
            logMessage(user + ": " + message);
        }
    }

    private void login() {
        user = loginField.getText();
        if (!user.isEmpty()) {
            logMessage("Пользователь " + user + " подключен");
        }
        logoutButton.setEnabled(true);
        connectButton.setEnabled(false);
        sendButton.setEnabled(true);
    }

    private void logout() {
        logMessage("Пользователь " + user + " отключен");
        logoutButton.setEnabled(false);
        connectButton.setEnabled(true);
        sendButton.setEnabled(false);
        user = "";
        ChatLogger.saveLog(chatLog.getText());
    }

    private void loadLog() {
        String log = ChatLogger.readLog();
        if (!log.isEmpty()) {
            chatLog.append(log);
        }
    }

    private void logMessage(String message) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String timeString = time.format(dateTimeFormatter);
        chatLog.append(timeString + " > " + message + "\n");
    }
}
