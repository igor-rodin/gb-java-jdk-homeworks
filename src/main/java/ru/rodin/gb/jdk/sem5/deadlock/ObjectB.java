package ru.rodin.gb.jdk.sem5.deadlock;

public class ObjectB {

    synchronized public void methodB(ObjectA objectA) throws InterruptedException {
        System.out.println("methodB run with objectA");
        objectA.methodA();
    }

    synchronized public void methodB() {
        System.out.println("methodB");
    }
}
