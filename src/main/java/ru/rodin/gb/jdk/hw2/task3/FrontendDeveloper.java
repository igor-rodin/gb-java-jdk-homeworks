package ru.rodin.gb.jdk.hw2.task3;

public class FrontendDeveloper extends AbstractDeveloper implements Frontend {

    public FrontendDeveloper(String name, String position) {
        super(name, position);
    }

    public FrontendDeveloper() {
        super();
    }

    @Override
    public void makeGUI() {
        System.out.println("make GUI");
    }

    @Override
    protected void makeCode() {
        makeGUI();
    }
}
