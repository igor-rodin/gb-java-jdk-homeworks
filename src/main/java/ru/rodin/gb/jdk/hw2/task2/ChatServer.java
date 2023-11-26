package ru.rodin.gb.jdk.hw2.task2;

import ru.rodin.gb.jdk.hw2.server.ServerListener;

public class ChatServer implements ServerSocketThreadListener, SocketThreadListener {

    private ServerListener serverListener;
    private ServerSocketThread serverSocketThread;

    public ChatServer(ServerListener serverListener) {
        this.serverListener = serverListener;
        serverSocketThread = new ServerSocketThread(this);
    }

    @Override
    public void clientConnected(int id) {
        serverListener.msgReceived("Client " + id + " connected");
    }

    @Override
    public void clientDisconnected(int id) {
        serverListener.msgReceived("Client " + id + " disconnected");
    }

    @Override
    public void start() {
        serverListener.msgReceived("Сервер запущен");

    }

    @Override
    public void stop() {
        serverListener.msgReceived("Сервер остановлен");
    }

    @Override
    public void getMessage(int idFrom, String msg) {
        serverListener.msgReceived("Get message: " + msg + " from " + idFrom + " message");

    }

    @Override
    public void sentMessage(String msg) {
        serverListener.msgReceived("Sent message: " + msg);
    }

}
