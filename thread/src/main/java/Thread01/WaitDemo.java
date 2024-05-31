package Thread01;
public class WaitDemo {
    Object lock=new Object();
    boolean flag;


    public  void printA() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                while (!flag){
                    lock.wait();
                }
                System.out.println("A");
                flag=false;
                lock.notify();
                System.out.println("123");
            }
        }
    }
    public  void printB() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            synchronized (lock) {
                while (flag){
                    lock.wait();
                }
                System.out.println("B");
                flag=true;
                lock.notify();
                System.out.println("123");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread01.WaitDemo waitDemo = new Thread01.WaitDemo();
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
