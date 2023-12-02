package ru.rodin.gb.jdk.hw3.person;

public class Slacker implements Person {

    @Override
    public void doWork() {
        System.out.println("Slacker: I don't work");
    }

    @Override
    public void haveRest() {
        System.out.println("Slacker: I like to laze around");

    }

}
