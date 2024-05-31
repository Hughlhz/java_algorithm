package virtualthread;

import java.util.concurrent.Executors;

public class VirtualThreadsExample {
    public static void main(String[] args) {
        try (var executor = Executors.newThreadPerTaskExecutor(Thread.ofVirtual().factory())) {
            for (int i = 0; i < 100; i++) {
                int taskNumber = i;
                executor.submit(() -> {
                    System.out.println("Task " + taskNumber + " executed by " + Thread.currentThread());
                });
            }
        }
    }
}

