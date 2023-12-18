package ru.rodin.gb.jdk.sem5.deadlock;

/**
 * В рамках выполнения задачи необходимо:
 * - Создать два класса ObjectA, ObjectB
 * - Реализовать класс в котором два потока при запуске провоцируют DeadLock для
 * объектов ObjectA, ObjectB
 */
public class DeadLock {
    ObjectA objectA = new ObjectA();
    ObjectB objectB = new ObjectB();
    Thread threadA = new Thread(() -> {
        try {
            objectA.methodA(objectB);
        } catch (InterruptedException e) {
            System.out.println("ThradA interrupted");
        }
    });

    Thread threadB = new Thread(() -> {
        try {
            objectB.methodB(objectA);
        } catch (InterruptedException e) {
            System.out.println("ThradB interrupted");
        }
    });

    void start() {
        threadA.start();
        threadB.start();
    }

    public static void main(String[] args) {
        new DeadLock().start();
    }

}
