package ru.rodin.gb.jdk.hw3.person;

import java.util.ArrayList;
import java.util.List;

public class Workplace<T extends Person> {
    private List<T> persons = new ArrayList<>();

    public Workplace(List<T> persons) {
        this.persons = persons;
    }

    public void work() {
        System.out.println("Working place:");
        for (T p : persons) {
            p.doWork();
        }
    }

    public void rest() {
        System.out.println("Working place:");
        for (T p : persons) {
            p.haveRest();
        }
    }
};
