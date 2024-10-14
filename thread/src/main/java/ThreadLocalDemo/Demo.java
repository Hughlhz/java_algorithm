package ThreadLocalDemo;

public class Demo {
    private static final ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            int value = threadLocalValue.get();
            System.out.println("Thread 1: " + value);
            threadLocalValue.set(value + 1);
            System.out.println("Thread 1 updated: " + threadLocalValue.get());
        });

        Thread thread2 = new Thread(() -> {
            int value = threadLocalValue.get();
            System.out.println("Thread 2: " + value);
            threadLocalValue.set(value + 1);
            System.out.println("Thread 2 updated: " + threadLocalValue.get());
        });

        thread1.start();
        thread2.start();
    }
}