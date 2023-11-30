package ru.rodin.gb.jdk.lect3;

public class Fruits {

    public static void main(String[] args) {
        Apple apple = new Apple("green");
        Apple apple2 = new Apple("red");
        Apple apple3 = new Apple("yellow");
        Orange orange = new Orange("orange");
        Orange orange2 = new Orange("yellow");

        FruitBox<Orange> orangeBox = new FruitBox<>();
        orangeBox.add(orange);
        orangeBox.add(orange2);

        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(apple);
        appleBox.add(apple2);
        appleBox.add(apple3);

        System.out.println(appleBox.compare(orangeBox));

        FruitBox<Orange> newOrangeBox = new FruitBox<>();
        FruitBox<Apple> newAppleBox = new FruitBox<>();

        orangeBox.moveAllTo(newOrangeBox);
        System.out.println(orangeBox.getFruits());
        System.out.println(newOrangeBox.getFruits());

        appleBox.moveAllTo(newAppleBox);
        System.out.println(appleBox.getFruits());
        System.out.println(newAppleBox.getFruits());

        System.out.println(apple.getWeight());
        System.out.println(orange.getWeight());
    }
}
