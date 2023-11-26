package ru.rodin.gb.jdk.hw2.task3;

public class App {

    public static void main(String[] args) {
        FullstackDeveloper developer = new FullstackDeveloper();
        developer.makeBackend();
        developer.makeGUI();

        AbstractDeveloper[] developers = new AbstractDeveloper[] {
                new BackendDeveloper("Back", "junior"),
                new FrontendDeveloper("Front", "junior"),
                new FullstackDeveloper("Full", "senior")
        };

        for (AbstractDeveloper dev : developers) {
            System.out.println("Developer: " + dev.getName() + " " + dev.getPosition());
            dev.makeCode();
        }

        AbstractDeveloper dev = new FrontendDeveloper();
        FrontendDeveloper frontendDeveloper = (FrontendDeveloper) dev;
        frontendDeveloper.makeGUI();
    }
}
