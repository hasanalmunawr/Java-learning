package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ReactiveStreamTest {

    @Test
    void create() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        PrintSubcriber printSubcriber = new PrintSubcriber("hasan", 1000);
        PrintSubcriber printSubcriber2 = new PrintSubcriber("almu", 500);
        publisher.subscribe(printSubcriber);
        publisher.subscribe(printSubcriber2);

        executor.execute(() -> {
            for(int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(10);
                    publisher.submit("hasan-" + i);
                    System.out.println("send hasan- " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        Thread.sleep(100 * 1000);

    }
@Test
    void buffer() throws InterruptedException {
        var publiser = new SubmissionPublisher<String>(Executors.newFixedThreadPool(10), 50);
        var executor = Executors.newSingleThreadExecutor();
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>(Executors.newWorkStealingPool(), 50);

        PrintSubcriber printSubcriber = new PrintSubcriber("hasan", 1000);
        PrintSubcriber printSubcriber2 = new PrintSubcriber("almu", 500);
        publiser.subscribe(printSubcriber);
        publiser.subscribe(printSubcriber2);

        executor.execute(() -> {
            for(int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(10);
                    publisher.submit("hasan-" + i);
                    System.out.println("send hasan- " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        Thread.sleep(100 * 1000);

    }

    @Test
    void processor() throws InterruptedException {
        var executor = Executors.newSingleThreadExecutor();
        var forkJoin = Executors.newWorkStealingPool();

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>(forkJoin, 5);
        HelloProcessor helloProcessor = new HelloProcessor();
        publisher.subscribe(helloProcessor);

        var subcirbe = new PrintSubcriber("A", 1000);
        helloProcessor.subscribe(subcirbe);

        executor.execute(() -> {
            for(int i = 0; i < 1000; i++) {
                try {
                    Thread.sleep(10);
                    publisher.submit("hasan-" + i);
                    System.out.println("send hasan- " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    private static class PrintSubcriber implements Flow.Subscriber<String> {

        private Flow.Subscription subscription;

        private String name ;
        private long sleep;

        public PrintSubcriber(String name, long sleep) {
            this.name = name;
            this.sleep = sleep;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String s) {
            try {
                Thread.sleep(sleep);
                System.out.println(Thread.currentThread().getName() + name + " : " + s);
                this.subscription.request(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
            System.out.println(Thread.currentThread().getName() + " : DONE ");
        }
    }

    private static class HelloProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {

        private Flow.Subscription subscription;
        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            this.subscription = subscription;
            this.subscription.request(1);
        }

        @Override
        public void onNext(String s) {
            submit("Hello " + s);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            throwable.printStackTrace();
        }

        @Override
        public void onComplete() {
close();
        }
    }
}
