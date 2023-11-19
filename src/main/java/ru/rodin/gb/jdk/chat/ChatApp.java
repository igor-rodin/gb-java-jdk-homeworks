package ru.rodin.gb.jdk.chat;

import java.awt.EventQueue;

public class ChatApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ChatWindow();
        });
    }

}
