package ru.rodin.gb.jdk.hw2.task3;

public class FullstackDeveloper extends AbstractDeveloper implements Frontend, Backend {
    public FullstackDeveloper(String name, String position) {
        super(name, position);
    }

    public FullstackDeveloper() {
        super();
    }

    @Override
    public void makeGUI() {
        System.out.println("make GUI");

    }

    @Override
    public void makeBackend() {
        System.out.println("make backend");

    }

    @Override
    protected void makeCode() {
        makeGUI();
        makeBackend();
    }

}
