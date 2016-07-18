package com.wuyaxin.concurrency.join;

/**
 * Created by wuyaxin on 16/7/17.
 */
class T2 extends T {


    T2(Thread dependentThread) {
        super(dependentThread);
    }

    public void doRun() {
        System.out.println("This is thread named com.wuyaxin.concurrency.join.T2");
    }
}
