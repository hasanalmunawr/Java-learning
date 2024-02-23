package hasan.almu.Thread;

import org.junit.jupiter.api.Test;
import org.w3c.dom.css.CSSImportRule;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForkJoinTest {

    @Test
    void create() {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        ForkJoinPool forkJoinPool = new ForkJoinPool(5);

        var serviceEx = Executors.newWorkStealingPool();
        var service = Executors.newFixedThreadPool(5);

    }

    @Test
    void receiveAction() throws InterruptedException {
        var pool = ForkJoinPool.commonPool();
        List<Integer> list = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        pool.submit(new SimpleForkJoinTask(list));

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void recursiveTask() throws InterruptedException {
        var pool = ForkJoinPool.commonPool();
        List<Integer> list = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        TotalForkJoinTask task = new TotalForkJoinTask(list);

        pool.submit(task);
//        pool.awaitTermination(1, TimeUnit.MINUTES);
        Long total = task.join();
        System.out.println(total);

        Long longer = list.stream().mapToLong(value -> value).sum();
        System.out.println(longer);
    }

    private static  class SimpleForkJoinTask extends RecursiveAction {
        final private List<Integer> integers;

        public SimpleForkJoinTask(List<Integer> integers) {
            this.integers = integers;
        }

        @Override
        protected void compute() {
            if (integers.size() <= 10) {
                doExecute();
            } else {
                forkcompute();
            }
        }
        private void doExecute() {
            integers.forEach(integer -> System.out.println(Thread.currentThread().getName() + " : " + integer));
        }
        private void forkcompute() {
            List<Integer> list = this.integers.subList(0, this.integers.size() / 2);
            List<Integer> list1 = this.integers.subList(this.integers.size() / 2, this.integers.size());

            SimpleForkJoinTask task = new SimpleForkJoinTask(list);
            SimpleForkJoinTask task1 = new SimpleForkJoinTask(list1);

            ForkJoinTask.invokeAll(task, task1);

        }
    }

    private static  class TotalForkJoinTask extends RecursiveTask<Long> {

        List<Integer> list ;

        public TotalForkJoinTask(List<Integer> list) {
            this.list = list;
        }

        @Override
        protected Long compute() {
            if(list.size() <= 10) {
               return doCompute();
            } else {
                return forkCompute();
            }

        }

        private Long forkCompute() {
            List<Integer> list1 = this.list.subList(0, this.list.size() / 2);
            TotalForkJoinTask task1 = new TotalForkJoinTask(list1);

            List<Integer> list2 = this.list.subList(this.list.size() / 2, this.list.size());
            TotalForkJoinTask task2 = new TotalForkJoinTask(list2);

            ForkJoinTask.invokeAll(task1, task2);
            return task1.join() + task2.join();
        }

        private Long doCompute() {
            return list.stream().mapToLong(value -> value).peek(value -> {
                System.out.println(Thread.currentThread().getName() + " : " + value);
            }).sum();
        }
    }
}
