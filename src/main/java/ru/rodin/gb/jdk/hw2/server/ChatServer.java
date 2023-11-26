package ru.rodin.gb.jdk.hw2.server;

public class ChatServer {
    private boolean isRunning;
    private ServerListener serverListener;

    public ChatServer(ServerListener serverListener) {
        this.serverListener = serverListener;
        isRunning = false;
    }

    public void start() {
        if (isRunning) {
            serverListener.msgReceived("Сервер уже запущен");
            return;
        }
        isRunning = true;
        serverListener.msgReceived("Сервер запущен");
    }

    public void stop() {
        if (!isRunning) {
            serverListener.msgReceived("Сервер уже остановлен");
            return;
        }
        isRunning = false;
        serverListener.msgReceived("Сервер остановлен");
    }
}
