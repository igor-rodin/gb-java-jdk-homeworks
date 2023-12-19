package ru.rodin.gb.jdk.hw5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
    private final static int TIME_TO_EAT = 500;
    private final static int COUNT_EAT = 3;

    private final String name;
    private static final ReentrantLock lockFood = new ReentrantLock(false);

    public Philosopher(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int eats = 0;
        while (eats++ < COUNT_EAT) {
            try {
                eat(eats);
                think();
            } catch (InterruptedException e) {
                System.out.println(name + " is died");
            }
        }
    }

    private void eat(int eats) throws InterruptedException {
        lockFood.lock();
        try {
            System.out.println(name + " is eating(" + eats + ")");
            TimeUnit.MILLISECONDS.sleep(TIME_TO_EAT);
        } finally {
            lockFood.unlock();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(name + " is thinking");
    }

}
