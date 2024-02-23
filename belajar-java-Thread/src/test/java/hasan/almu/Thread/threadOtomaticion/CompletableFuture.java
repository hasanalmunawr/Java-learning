package hasan.almu.Thread.threadOtomaticion;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;


public class CompletableFuture {

//    MEMBUAT FUTURE SECARA MENUAL
    private ExecutorService executor = Executors.newFixedThreadPool(10);
    private Random random = new Random();

    private java.util.concurrent.CompletableFuture<String> getValue() {
        java.util.concurrent.CompletableFuture<String> future = new java.util.concurrent.CompletableFuture<>();
        executor.execute(() -> {
            try {
                Thread.sleep(1000);
                future.complete("hasan almunawar");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }

        });
        return future;
    }
    @Test
    void create() throws ExecutionException, InterruptedException {
        Future<String> future = getValue();
        System.out.println(future.get());
    }

    private  void execute(java.util.concurrent.CompletableFuture<String> future, String value ){
        executor.execute(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(5000));
                future.complete(value);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
    }

    private Future<String> getFast() {
        java.util.concurrent.CompletableFuture<String> future = new java.util.concurrent.CompletableFuture<>();

        execute(future, "thread 1");
        execute(future, "thread 2");
        execute(future, "thread 3");
        execute(future, "thread 4");
        return future;
    }

    @Test
    void testFast() throws ExecutionException, InterruptedException {
        System.out.println(getFast().get());
    }

    @Test
    void compltionStageTest() throws ExecutionException, InterruptedException {
        java.util.concurrent.CompletableFuture<String> stringCompletableFuture = getValue();

        java.util.concurrent.CompletableFuture<String[]> future = stringCompletableFuture.thenApply(string -> string.toUpperCase())
                .thenApply(String -> toString().split(" "));

        String[] strings = future.get();
        for(var value : strings) {
            System.out.println(value);
        }

    }
}
