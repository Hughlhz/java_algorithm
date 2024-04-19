package Thread012;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintSequence {
    private int n;
    private int count = 1;
    private volatile int state=0;
    private Lock lock = new ReentrantLock();
    boolean flag=false;
    private Condition printA = lock.newCondition();
    private Condition printB = lock.newCondition();
    private Condition printC = lock.newCondition();

    public PrintSequence(int n) {
        this.n = n;
    }

    public void printA() throws InterruptedException {
        for(int i=0;i<n;i++){
            lock.lock();
        try {

            while (state != 0) {
                printA.await();
            }
            System.out.println(0);
            if(i%2==0){
                state=1;
                printB.signal();}
            else {
                state=2;
                printC.signal();
            }
        }finally {
            lock.unlock();
        }}

    }

    public void printB() throws InterruptedException {
        for(int i=1;i<=n;i+=2){
            lock.lock();
            try {

                while (state != 1) {
                    printB.await();
                }
                System.out.println(i);
                state=0;
                printA.signal();
            }finally {
                lock.unlock();
            }}

    }

    public void printC() throws InterruptedException {
        for(int i=2;i<=n;i+=2){
            lock.lock();
            try {

                while (state != 2) {
                    printC.await();
                }
                System.out.println(i);
                state=0;
                printA.signal();
            }finally {
                lock.unlock();
            }}
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 10; // 设置要打印的数字范围
        PrintSequence printSequence = new PrintSequence(n);
        Thread A =new Thread(() -> {
            try {
                printSequence.printA();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread B =new Thread(() -> {
            try {
                printSequence.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread C = new Thread(() -> {
            try {
                printSequence.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        A.start();
        B.start();
        C.start();
        A.join();
        B.join();
        C.join();
    }
}
