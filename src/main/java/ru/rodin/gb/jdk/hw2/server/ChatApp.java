package ru.rodin.gb.jdk.hw2.server;

import java.awt.EventQueue;

public class ChatApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ChatWindow();
        });
    }
}
