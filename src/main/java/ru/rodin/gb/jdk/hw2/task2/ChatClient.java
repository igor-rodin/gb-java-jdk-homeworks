package ru.rodin.gb.jdk.hw2.task2;

import ru.rodin.gb.jdk.hw2.server.ServerListener;

public class ChatClient implements SocketThreadListener {

    private ServerListener listener;
    private SocketThread socketThread;

    public ChatClient(ServerListener listener) {
        this.listener = listener;
        socketThread = new SocketThread(this);
    }

    @Override
    public void getMessage(int idFrom, String msg) {
        listener.msgReceived("Get message: " + msg + " from " + idFrom + " message");
    }

    @Override
    public void sentMessage(String msg) {
        listener.msgReceived("Sent message: " + msg);
    }

}
