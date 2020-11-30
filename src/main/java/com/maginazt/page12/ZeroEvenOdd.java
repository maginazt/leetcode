package com.maginazt.page12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author: zhaotao
 * @date: 2020/11/24 11:20
 */
public class ZeroEvenOdd {

    private static final int ZERO_ODD = 3;
    private static final int ZERO_EVEN = 4;
    private static final int ODD = 1;
    private static final int EVEN = 2;

    private int n;
    private int status;
    private int counter;
    private Lock lock;
    private Condition printZero;
    private Condition printOdd;
    private Condition printEven;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.status = ZERO_ODD;
        this.counter = 1;
        this.lock = new ReentrantLock();
        this.printZero = lock.newCondition();
        this.printOdd = lock.newCondition();
        this.printEven = lock.newCondition();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            lock.lockInterruptibly();
            try {
                if (status != ZERO_ODD && status != ZERO_EVEN) {
                    printZero.await();
                }
                printNumber.accept(0);
                if (status == ZERO_ODD) {
                    status = ODD;
                    printOdd.signal();
                } else {
                    status = EVEN;
                    printEven.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n / 2; i++) {
            lock.lockInterruptibly();
            try {
                if (status != EVEN) {
                    printEven.await();
                }
                printNumber.accept(counter++);
                status = ZERO_ODD;
                printZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        int size = n / 2 + n % 2;
        for (int i = 0; i < size; i++) {
            lock.lockInterruptibly();
            try {
                if (status != ODD) {
                    printOdd.await();
                }
                printNumber.accept(counter++);
                status = ZERO_EVEN;
                printZero.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 12;
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        IntConsumer intConsumer = System.out::print;
        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.even(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}
