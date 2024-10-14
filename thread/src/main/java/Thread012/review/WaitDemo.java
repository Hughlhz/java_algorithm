package Thread012.review;

public class WaitDemo {
    Object lock= new Object();
    Object lock1 =new Object();
    Object lock2 =new Object();

    int state=0;
    int n;
    public WaitDemo(int n){
        this.n=n;
    }
    private void printA() throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock){
                while (state!=0){
                    lock.wait();
                }
                System.out.print(0);
                if(i%2==0) state=1;
                else state=2;
                lock.notifyAll();
            }
        }
    }
    private void printB() throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            synchronized (lock){
                while (state!=1){
                    lock.wait();
                }
                System.out.print(i);
                state=0;
                lock.notifyAll();
            }
        }
    }
    private void printC() throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            synchronized (lock){
                while (state!=2){
                    lock.wait();
                }
                System.out.print(i);
                state=0;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitDemo waitDemo = new WaitDemo(100);
        Thread a=new Thread(()->{
            try {
                waitDemo.printA();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread b=new Thread(()->{
            try {
                waitDemo.printB();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread c=new Thread(()->{
            try {
                waitDemo.printC();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        a.start();
        b.start();
        c.start();
        a.join();
        b.join();
        c.join();
    }
}
