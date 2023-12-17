package ru.rodin.gb.jdk.sem5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Atomic {
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        IntStream.range(0, 1000).forEach(i -> {
            Runnable task = () -> {
                atomicInteger.updateAndGet(n -> n + 2);
            };
            executor.submit(task);
        });
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println(atomicInteger.get());
    }

}
