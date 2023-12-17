package ru.rodin.gb.jdk.sem5.switcher;

public class SwitchState {
    volatile private boolean switcherState;
    volatile private boolean isDone;

    public void flip() {
        switcherState = !switcherState;
    }

    public boolean getSwitcherState() {
        return switcherState;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }
}
