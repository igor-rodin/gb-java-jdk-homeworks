package ru.rodin.gb.jdk.hw2.task3;

public class BackendDeveloper extends AbstractDeveloper implements Backend {

    public BackendDeveloper(String name, String position) {
        super(name, position);
    }

    public BackendDeveloper() {
        super();
    }

    @Override
    public void makeBackend() {
        System.out.println("make backend");
    }

    @Override
    protected void makeCode() {
        makeBackend();
    }
}
