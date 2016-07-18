package com.wuyaxin.concurrency.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wuyaxin on 16/7/17.
 */
class ArrayBlockingQueue<T> {
    // data structure
    private final Object[] elements;
    // lock
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private int takeIndex = 0;
    private int putIndex = 0;
    private int count = 0;

    ArrayBlockingQueue(int capacity) {
        elements = new Object[capacity];
    }

    void put(T value) {
        lock.lock();

        try {

            // if full, wait until not full
            while (count == elements.length) {
                notFull.await();
            }


            elements[putIndex++] = value;
            count++;

            if (putIndex == elements.length) {
                putIndex = 0;
            }

            notEmpty.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    T take() {

        T returnValue = null;

        lock.lock();

        try {
            while (count == 0) {
                notEmpty.wait();
            }

            returnValue = (T) elements[takeIndex];
            elements[takeIndex] = null;
            count--;

            if (++takeIndex == elements.length) takeIndex = 0;

            notFull.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return returnValue;
    }
}
