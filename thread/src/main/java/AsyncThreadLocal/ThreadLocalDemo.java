package AsyncThreadLocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadLocalDemo {
//        private static ThreadLocal<String> localStr = new ThreadLocal<>();
//        private static InheritableThreadLocal<String> localStr = new InheritableThreadLocal<>();
    private static TransmittableThreadLocal<String> localStr=new TransmittableThreadLocal<>();

    static Executor executorService ;

    public void test() {
        localStr.set("123");
        System.out.println(Thread.currentThread().getName() + " " + localStr.get());
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " " + localStr.get());
        });

        executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " " + localStr.get());
        });
    }
    public void test001(){
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " " + localStr.get());
        });
    }

    public static void main(String[] args) throws InterruptedException {
        executorService= Executors.newFixedThreadPool(1);
        //1、模拟传递，传递到线程池中
        ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        threadLocalDemo.test();
        Thread.sleep(2000);
        //2、模拟重新设置 发现普通的线程池中线程的local只有第一次传递时拷贝的值
        localStr.set("=======");
        threadLocalDemo.test001();
        //3、尝试使用TTL包装的线程池
        Executor ttlExecutor = TtlExecutors.getTtlExecutor(executorService);
        System.out.println("================================================");
        executorService=ttlExecutor;
        threadLocalDemo.test();
        Thread.sleep(2000);
        //2、模拟重新设置 发现普通的线程池中线程的local只有第一次传递时拷贝的值
        localStr.set("=======");
        threadLocalDemo.test001();
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(5,10,100,null,null);
        ExecutorService es = TtlExecutors.getTtlExecutorService(threadPoolExecutor);


    }
}
