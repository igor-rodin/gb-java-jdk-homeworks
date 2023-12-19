package ru.rodin.gb.jdk.hw5;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher implements Runnable {
    private final static int TIME_TO_EAT = 500;
    private final static int COUNT_EAT = 3;

    private final String name;
    private final ReentrantLock lockFood;

    public Philosopher(String name, ReentrantLock lockFood) {
        this.name = name;
        this.lockFood = lockFood;
    }

    @Override
    public void run() {
        int eats = 0;
        while (eats++ < COUNT_EAT) {
            try {
                think();
                eat(eats);
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
        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(100, TIME_TO_EAT - 100));
    }

}
