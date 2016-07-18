package com.wuyaxin.concurrency.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by wuyaxin on 16/7/17.
 */
public class ConcurrentHashMap<K, V> {
    private Map<K, V> internal_map = new HashMap<K, V>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    public V get(K key) {
        rwl.readLock().lock();
        System.out.println(Thread.currentThread() + " acquired read lock!");


        try {

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return internal_map.get(key);
        } finally {
            rwl.readLock().unlock();
            System.out.println(Thread.currentThread() + " release read lock!");
        }

    }

    public void put(K key, V value) {
        rwl.writeLock().lock();
        System.out.println(Thread.currentThread() + " acquired write lock!");

        try {
            internal_map.put(key, value);
        } finally {
            rwl.writeLock().unlock();
            System.out.println(Thread.currentThread() + " release write lock!");
        }

    }

}
