package com.wuyaxin.concurrency.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by wuyaxin on 16/7/17.
 */
public class Main {
    public static void main(String[] args) {
        AtomicReference<String> ars = new AtomicReference<>();

        ars.set("v1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ars.set("v2");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!ars.compareAndSet("v2", "v3")) {
                    System.out.println("wait for ars" + System.currentTimeMillis());
                }

                System.out.println(ars.get());
            }
        }).start();

    }
}
