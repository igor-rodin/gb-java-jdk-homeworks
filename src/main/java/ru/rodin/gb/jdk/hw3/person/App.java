package ru.rodin.gb.jdk.hw3.person;

import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Person> persons = List.of(new Worker(), new Worker(), new Slacker());
        Workplace<Person> workplace = new Workplace<>(persons);
        Club<Person> club = new Club<>(persons);
        workplace.work();

        club.rest();
    }
}
