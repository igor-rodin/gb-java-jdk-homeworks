package ru.rodin.gb.jdk.hw3.person;

public class Worker implements Person {

    @Override
    public void doWork() {
        System.out.println("Worker: I like work");

    }

    @Override
    public void haveRest() {
        System.out.println("Worker: I can't rest");
    }

}
