package ru.rodin.gb.jdk.sem5.deadlock;

import java.util.concurrent.TimeUnit;

public class ObjectA {

    synchronized public void methodA(ObjectB objectB) throws InterruptedException {
        System.out.println("methodA run with objectB");
        TimeUnit.SECONDS.sleep(1);
        objectB.methodB();
    }

    synchronized public void methodA() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("methodA");
    }
}
