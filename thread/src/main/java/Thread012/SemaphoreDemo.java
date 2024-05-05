package Thread012;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
     Semaphore a = new Semaphore(1);
     Semaphore b = new Semaphore(0);
     Semaphore c = new Semaphore(0);
     int n;

    public SemaphoreDemo(int n) {
        this.n = n;
    }

    void printA() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            a.acquire();
            System.out.print(0);
            if(i%2==0){
                b.release();
            }else {
                c.release();
            }
        }

    }
     void printB() throws InterruptedException {
         for (int i = 0; i < n; i+=2) {
             b.acquire();
             System.out.print(i+1);
             a.release();
         }

    }
     void printC() throws InterruptedException {
         for (int i = 1; i < n; i += 2) {
             c.acquire();
             System.out.print(i + 1);
             a.release();
         }

    }


    public static void main(String[] args) throws InterruptedException {
        SemaphoreDemo semaphoreDemo = new SemaphoreDemo(10);
        Thread threadA = new Thread(() -> {
            try {
                semaphoreDemo.printA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                semaphoreDemo.printB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread threadC = new Thread(() -> {
            try {
                semaphoreDemo.printC();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
        threadA.join();
        threadB.join();
        threadC.join();
    }
}
