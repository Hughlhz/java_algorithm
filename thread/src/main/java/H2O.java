import annotations.Star;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@Star("理解使用lock和condition，condition只是一种信号传递的方式，唤醒者先修改条件满足被唤醒者，被唤醒者被唤醒后仍然会在循环中检查一遍条件是否满足，一定要满足才唤醒，不然可能会导致线程都在等待condition，但是却没有线程主动signal()")
public class H2O {
    private int hcount = 0;
    private int ocount = 0;
    Lock lock=new ReentrantLock();
    Condition condition= lock.newCondition();


    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        lock.lock();
        try{
            while (hcount==2){
                condition.await();
            }
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            hcount++;
            if(hcount==2&&ocount==1){
                hcount=0;
                ocount=0;
                condition.signal();
            }else if(ocount==0){
                condition.signal();
            }
        }finally {
            lock.unlock();
        }




    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        lock.lock();
        try {
            while (ocount==1){
                condition.await();
            }
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            ocount++;
            if(hcount==2&&ocount==1){
                hcount=0;
                ocount=0;
            }
            condition.signal();

        }finally {
            lock.unlock();
        }

    }

}
