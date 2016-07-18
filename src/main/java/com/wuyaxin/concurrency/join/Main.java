package com.wuyaxin.concurrency.join;

/**
 * Created by wuyaxin on 16/7/17.
 */
public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2(t1));
        Thread t3 = new Thread(new T3(t2));
        t1.start();
        t2.start();
        t3.start();
    }
}
