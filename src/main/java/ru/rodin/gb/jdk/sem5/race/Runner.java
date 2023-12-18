package ru.rodin.gb.jdk.sem5.race;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Runner implements Runnable {
    private String name;
    private final CountDownLatch countDownLatch;
    private final CountDownLatch cdlGo;
    private final int speed;

    public Runner(String name, CountDownLatch countDownLatch, CountDownLatch cdlGo) {
        this.name = name;
        this.cdlGo = cdlGo;
        this.countDownLatch = countDownLatch;
        speed = ThreadLocalRandom.current().nextInt(2000, 5000);
    }

    @Override
    public void run() {
        try {
            goToStart();
            startRace();
        } catch (InterruptedException e) {
            System.out.println(name + " прервал гонку");
        }
    }

    private void startRace() throws InterruptedException {
        cdlGo.await();
        System.out.println(name + " начинает гонку");
        TimeUnit.MILLISECONDS.sleep(speed);
        System.out.println(String.format("%s финишировал за %s миллисекунд", name, speed));
    }

    private void goToStart() throws InterruptedException {
        System.out.println(name + " иду на старт");
        TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
        System.out.println(name + " готов");
        countDownLatch.countDown();
    }
}
