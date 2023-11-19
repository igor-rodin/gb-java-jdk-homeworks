package ru.rodin.gb.jdk.chat;

import java.awt.EventQueue;

import ru.rodin.gb.jdk.chat.ui.ChatWindow;

public class ChatApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ChatWindow();
        });
    }

}
