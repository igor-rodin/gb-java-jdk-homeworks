package ru.rodin.gb.jdk.sem5.philosoph;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AppClassicPhilosopher implements Runnable {
    private static final int PHILOSOPH_COUNT = 5;

    private final ExecutorService executor = Executors.newFixedThreadPool(PHILOSOPH_COUNT);
    private final ReentrantLock[] forks = new ReentrantLock[PHILOSOPH_COUNT];

    public AppClassicPhilosopher() {
        for (int i = 0; i < PHILOSOPH_COUNT; i++) {
            forks[i] = new ReentrantLock(true);
        }
        for (int i = 0; i < PHILOSOPH_COUNT - 1; i++) {
            executor.submit(new ClassicPhilosopher("Философ " + (i + 1), forks[i], forks[(i + 1) % PHILOSOPH_COUNT]));
        }
        executor.submit(new ClassicPhilosopher("Философ " + (PHILOSOPH_COUNT), forks[0], forks[PHILOSOPH_COUNT - 1]));
    }

    @Override
    public void run() {
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(new AppClassicPhilosopher()).start();
    }
}
