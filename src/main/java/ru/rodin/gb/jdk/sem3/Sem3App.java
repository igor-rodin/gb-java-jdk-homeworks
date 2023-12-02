package ru.rodin.gb.jdk.sem3;

public class Sem3App {
    public static void main(String[] args) {
        MyCollection<Double> doubles = new MyCollection<>();
        doubles.add(2.);
        doubles.add(23.5);
        doubles.add(0.5);
        doubles.add(-10.5);
        for (int i = 0; i < doubles.getSize(); i++) {
            System.out.println(doubles.get(i));
        }
        doubles.remove(0.5);
        for (int i = 0; i < doubles.getSize(); i++) {
            System.out.println(doubles.get(i));
        }
    }
}
