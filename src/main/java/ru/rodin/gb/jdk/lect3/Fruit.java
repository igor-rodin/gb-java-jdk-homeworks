package ru.rodin.gb.jdk.lect3;

public abstract class Fruit {

    protected String name;
    protected float weight;

    protected Fruit(String name) {
        this.name = name;
        this.weight = 1.0f;
    }

    protected Fruit() {
        this("Fruit");
    }

    protected float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name;
    }

}
