package ru.rodin.gb.jdk.sem5.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * В рамках выполнения задачи необходимо:
 * - 3 бегуна должны прийти к старту гонки
 * - Программа должна гарантировать, что гонка начнется только когда все три
 * участника будут на старте
 * - Программа должна отсчитать “На старт”, “Внимание”, “Марш”
 * - Программа должна завершиться когда все участники закончат гонку.
 * - Подумайте об использовании примитива синхронизации
 */
public class Race implements Runnable {
    private static final int ATHLETES_COUNT = 3;

    private final CountDownLatch countDownLatch = new CountDownLatch(ATHLETES_COUNT);
    private final CountDownLatch cdlGo = new CountDownLatch(1);
    private final ExecutorService executor = Executors.newFixedThreadPool(ATHLETES_COUNT);

    public static void main(String[] args) {
        new Thread(new Race()).start();
    }

    private void go() throws InterruptedException {
        System.out.println("На старт!");
        executor.submit(new Runner("Участник 1", countDownLatch, cdlGo));
        executor.submit(new Runner("Участник 2", countDownLatch, cdlGo));
        executor.submit(new Runner("Участник 4", countDownLatch, cdlGo));
        executor.shutdown();
        countDownLatch.await();
        System.out.println("Внимание!");
        System.out.println("Марш!");
        cdlGo.countDown();
    }

    @Override
    public void run() {
        try {
            go();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
