package ru.rodin.gb.jdk.sem5.switcher;

import java.util.concurrent.TimeUnit;

public class ThreadA implements Runnable {
    private SwitchState switcherState;

    public ThreadA(SwitchState switcherState) {
        this.switcherState = switcherState;
    }

    @Override
    public void run() {
        while (!switcherState.isDone()) {
            switcherState.flip();
            if (switcherState.getSwitcherState()) {
                System.out.println(switcherState.getSwitcherState());
            }
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("ThreadA interrupted");
            }
        }

    }

}
