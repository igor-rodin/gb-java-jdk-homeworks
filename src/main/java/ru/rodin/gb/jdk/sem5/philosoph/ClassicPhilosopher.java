package ru.rodin.gb.jdk.sem5.philosoph;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ClassicPhilosopher implements Runnable {
    private final static int TIME_TO_EAT = 500;
    private final static int COUNT_EAT = 3;

    private final String name;
    private final ReentrantLock leftFork;
    private final ReentrantLock rightFork;

    public ClassicPhilosopher(String name, ReentrantLock leftFork, ReentrantLock rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
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

    private void think() throws InterruptedException {
        System.out.println(name + " is thinking");
        TimeUnit.MILLISECONDS.sleep(100);
    }

    private void eat(int eats) throws InterruptedException {
        boolean successfullyAte = false;

        while (!successfullyAte) {
            if (leftFork.tryLock()) {
                try {
                    if (rightFork.tryLock()) {
                        try {
                            System.out.println(name + " начал обедать. (" + eats + ")");
                            TimeUnit.MILLISECONDS.sleep(TIME_TO_EAT); // Время приема пищи
                            System.out.println(name + " закончил обедать.(" + eats + ")");
                            successfullyAte = true;
                        } finally {
                            rightFork.unlock();
                        }
                    }
                } finally {
                    leftFork.unlock();
                }
            }
        }
    }
}
