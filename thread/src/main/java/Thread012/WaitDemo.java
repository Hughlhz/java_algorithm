package Thread012;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaitDemo {
    //     final Object a = new Object();
//     Object b = new Object();
//    Semaphore a = new Semaphore(1);
//    Semaphore b = new Semaphore(0);
    Lock lock=new ReentrantLock();
    Condition a =lock.newCondition();
    Condition b =lock.newCondition();
    int state=0;

    public  void printA() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            while (state!=0){
                a.await();
            }
            System.out.println("A");
            state=1;
            b.signal();
            lock.unlock();
        }
    }
    public  void printB() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            while (state!=1){
                b.await();
            }
            System.out.println("B");
            state=0;
            a.signal();
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitDemo waitDemo = new WaitDemo();
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
