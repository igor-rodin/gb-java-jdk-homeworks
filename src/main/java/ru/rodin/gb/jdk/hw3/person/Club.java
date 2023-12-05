package ru.rodin.gb.jdk.hw3.person;

import java.util.ArrayList;
import java.util.List;

public class Club<T extends Person> {
    private List<T> persons = new ArrayList<>();

    public Club(List<T> persons) {
        this.persons = persons;
    }

    public void rest() {
        System.out.println("In club:");
        for (T p : persons) {
            p.haveRest();
        }
    }
};
