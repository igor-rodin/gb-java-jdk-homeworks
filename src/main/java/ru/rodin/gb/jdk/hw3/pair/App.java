package ru.rodin.gb.jdk.hw3.pair;

public class App {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(2, "second");
        System.out.println(pair1);

        Pair<Integer, Pair<Integer, String>> pair2 = new Pair<>(1, pair1);
        System.out.println(pair2);
    }
}
