package ru.rodin.gb.jdk.hw5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LunchingPhilosophers implements Runnable {
    private static final int PHILOSOPH_COUNT = 5;

    private final ExecutorService executor = Executors.newFixedThreadPool(PHILOSOPH_COUNT);
    private final ReentrantLock lock = new ReentrantLock(false);

    public LunchingPhilosophers() {
        executor.submit(new Philosopher("Платон", lock));
        executor.submit(new Philosopher("Аристотель", lock));
        executor.submit(new Philosopher("Кант", lock));
        executor.submit(new Philosopher("Сократ", lock));
        executor.submit(new Philosopher("Ницше", lock));
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        try {
            executor.shutdown();
            boolean res = executor.awaitTermination(10, TimeUnit.SECONDS);
            if (res) {
                long delta = System.currentTimeMillis() - start;
                System.out.println("Время работы: " + delta + " миллисекунд");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Thread(new LunchingPhilosophers()).start();
    }
}
