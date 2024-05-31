package Thread01;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreDemo {
    //     final Object a = new Object();
//     Object b = new Object();
    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(0);


    public  void printA() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            a.acquire();
            System.out.println("A");
            b.release();
        }
    }
    public  void printB() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            b.acquire();
            System.out.println("B");
            a.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SemaphoreDemo waitDemo = new SemaphoreDemo();
        Thread a=new Thread(() -> {
            try {
                waitDemo.printA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread b=new Thread(() -> {
            try {
                waitDemo.printB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        a.start();
        b.start();
        a.join();
        b.join();
    }
}
