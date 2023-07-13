package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadMain {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.submit(() -> {

        });
        List<Object> objects = new ArrayList<>();
        System.out.println(Thread.activeCount());
        System.out.println(Thread.currentThread());
    }
}
