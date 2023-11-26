package ru.rodin.gb.jdk.hw2.task3;

abstract public class AbstractDeveloper implements Developer {
    private String name;
    private String position;

    protected AbstractDeveloper(String name, String position) {
        this.name = name;
        this.position = position;
    }

    protected AbstractDeveloper() {
        this("unknown", "unknown");
    }

    protected abstract void makeCode();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
