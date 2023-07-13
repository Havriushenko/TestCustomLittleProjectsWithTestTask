package thread;

import javax.annotation.concurrent.NotThreadSafe;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@NotThreadSafe
public class AppTestTasks {

    public static void main(String[] args) throws InterruptedException {
//        Map<TestEntity,String> map = new HashMap<>();
//
//        for(int i = 0;i < 10;i++){
//            map.put(new TestEntity(i,"name" + i),"name" + i);
//        }
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        System.out.println("Current Thread name: " + Thread.currentThread().getName());
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            int i = 0;
            while (i < 1000) {
                System.out.println("Current Thread name: " + Thread.currentThread().getName());
                System.out.println("i = " + i++);
            }
        }, executorService);
        Thread.sleep(1000);
        System.out.println("Current Thread name: " + Thread.currentThread().getName());
        Runnable thread = () -> {
                System.out.println("Hello");
        };
    }

}
