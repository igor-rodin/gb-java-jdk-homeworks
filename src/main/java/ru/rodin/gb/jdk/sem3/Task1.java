package ru.rodin.gb.jdk.sem3;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.InputStream;

// Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные типа (T, V, K), 
// конструктор, принимающий на вход параметры типа (T, V, K), методы
// возвращающие значения трех переменных. Создать метод, выводящий на консоль имена
// классов для трех переменных класса. Наложить ограничения на параметры типа: 
//T должен реализовать интерфейс Comparable (классы оболочки, String), V должен реализовать интерфейс DataInput и расширять 
// класс InputStream, K должен расширять класс Number

public class Task1<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T t;
    private K k;
    private V v;

    public Task1(T t, V v, K k) {
        this.t = t;
        this.k = k;
        this.v = v;
    }

    T getT() {
        return t;
    }

    K getK() {
        return k;
    }

    V getV() {
        return v;
    }

    public void printClassNames() {
        System.out.println(t.getClass().getName());
        System.out.println(k.getClass().getName());
        System.out.println(v.getClass().getName());
    }

    public static void main(String[] args) {
        DataInputStream v = new DataInputStream(System.in);
        Task1<String, DataInputStream, Integer> task1 = new Task1<>("string", v, 5);
        task1.printClassNames();
    }
}
