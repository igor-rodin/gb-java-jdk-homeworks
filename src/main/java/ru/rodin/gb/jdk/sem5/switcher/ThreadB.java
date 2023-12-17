package ru.rodin.gb.jdk.sem5.switcher;

import java.util.concurrent.TimeUnit;

public class ThreadB implements Runnable {
    private static final int TICKS_COUNT = 100;
    private SwitchState switcherState;

    public ThreadB(SwitchState switcherState) {
        this.switcherState = switcherState;
    }

    @Override
    public void run() {
        int counter = TICKS_COUNT;
        while (counter > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (switcherState.getSwitcherState()) {
                try {
                    System.out.println(counter--);
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("ThreadB interrupted");
                }
            }
        }
        switcherState.setDone();
    }
}
