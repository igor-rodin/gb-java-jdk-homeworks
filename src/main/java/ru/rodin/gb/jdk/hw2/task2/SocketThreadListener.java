package ru.rodin.gb.jdk.hw2.task2;

public interface SocketThreadListener {
    void getMessage(int idFrom, String msg);

    void sentMessage(String msg);
}
