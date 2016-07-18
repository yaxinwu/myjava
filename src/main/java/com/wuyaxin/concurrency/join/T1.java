package com.wuyaxin.concurrency.join;

/**
 * Created by wuyaxin on 16/7/17.
 */
public class T1 extends T {

    T1() {
    }

    public T1(Thread dependentThread) {
        super(dependentThread);
    }

    public void doRun() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("This is thread named com.wuyaxin.concurrency.join.T1");
    }
}
