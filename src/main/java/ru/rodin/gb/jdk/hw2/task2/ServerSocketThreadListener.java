package ru.rodin.gb.jdk.hw2.task2;

public interface ServerSocketThreadListener {
    void start();

    void stop();

    void clientConnected(int id);

    void clientDisconnected(int id);
}
