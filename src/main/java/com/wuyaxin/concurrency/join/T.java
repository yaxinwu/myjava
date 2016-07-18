package com.wuyaxin.concurrency.join;

import java.util.Optional;

/**
 * Created by wuyaxin on 16/7/17.
 */
abstract class T implements Runnable {

    private Optional<Thread> dThread;

    T() {
        dThread = Optional.empty();
    }

    T(Thread dependentThread) {
        dThread = Optional.of(dependentThread);
    }

    public void run() {
        // run first
        try {
            if (dThread.isPresent()) {
                dThread.get().join();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // do itself things
        doRun();
    }

    abstract public void doRun();
}
