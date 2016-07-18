package com.wuyaxin.concurrency.queue;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wuyaxin on 16/7/17.
 */
public class Main {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(1);


        ExecutorService es = Executors.newFixedThreadPool(5);

        es.execute(() -> q.put("1"));

        es.execute(() -> q.take());

        es.shutdown();
    }
}
