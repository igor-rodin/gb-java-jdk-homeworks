package ru.rodin.gb.jdk.lect3;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit> {

    private List<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    boolean compare(FruitBox<? extends Fruit> fruit) {
        return this.getWeight() == fruit.getWeight();
    }

    public void moveAllTo(FruitBox<? super T> target) {
        for (T fruit : fruits) {
            target.add(fruit);
        }
        fruits.clear();
    }

    public List<T> getFruits() {
        return fruits;
    }
}
