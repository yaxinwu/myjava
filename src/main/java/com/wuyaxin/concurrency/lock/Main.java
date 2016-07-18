package com.wuyaxin.concurrency.lock;

/**
 * Created by wuyaxin on 16/7/17.
 */
public class Main {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> mymap = new ConcurrentHashMap<>();

        new Thread(() -> {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(mymap.get("key1"));
        }).start();


        new Thread(() -> {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(mymap.get("key2"));
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mymap.put("key1", "value1");
        }).start();


        new Thread(() -> {
            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mymap.put("key2", "value2");
        }).start();
    }
}
