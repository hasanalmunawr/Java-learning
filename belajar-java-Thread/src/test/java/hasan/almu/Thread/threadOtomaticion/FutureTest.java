package hasan.almu.Thread.threadOtomaticion;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureTest {

    @Test
    void create() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors .newSingleThreadExecutor();
        Future<String> future =  executor.submit(() -> {
            Thread.sleep(3000);
            return "HI";
        });

        while(!future.isDone()) {
            System.out.println("waiting sistem");
            Thread.sleep(1000);
        }
        System.out.println(future.get());
    }

    @Test
    void FutureCancel() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            Thread.sleep(5000);
            return "im here";
        });

        Thread.sleep(2000);
        System.out.println("Final system");
        future.cancel(true); // akan dibatalkan selama 2 detik
        System.out.println(future.isCancelled());
        System.out.println(future.get());
    }

    @Test
    void invokeAll() throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(operand -> (Callable<String>) () -> {
            Thread.sleep(operand * 500);
            return String.valueOf(operand);
        }).collect(Collectors.toList());



        // menggunakan invokeAll
        List<Future<String>> futures = executor.invokeAll(callables);
        for(Future<String> i : futures) {
            System.out.println(i.get());
        }
        // menual satu persatu
//        for(int i = 0; i < callables.size(); i++) {
//            Future<String> future = executor.submit(callables.get(i));
//            System.out.println(future.get());
//        }
    }

    @Test
    void invokeAny() throws ExecutionException, InterruptedException {
        ExecutorService exce = Executors.newSingleThreadExecutor();
        List<Callable<String>> callables = IntStream.range(1, 11).mapToObj(value -> (Callable<String>) () -> {
            Thread.sleep(value * 200);
            return String.valueOf(value);
        }).collect(Collectors.toList());

         String invo = exce.invokeAny(callables); // mengambil yang tercepat
        System.out.println(invo);
    }
}
