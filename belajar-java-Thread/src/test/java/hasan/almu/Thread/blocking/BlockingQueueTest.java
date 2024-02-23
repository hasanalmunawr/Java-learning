package hasan.almu.Thread.blocking;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueTest {

    @Test
    void test() throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5); //berjalan 5 diambil
        var sevice = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10 ; i++) {
            int index = i;
            sevice.execute(() -> {
                try {
                    queue.put("this input -" + index);
                    System.out.println("inputing");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        sevice.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    String value = queue.take();
                    System.out.println("receive value is " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println("finish get All date");

        sevice.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void priorityTest() throws InterruptedException {
        PriorityBlockingQueue<Integer> integerPriorityQueue = new PriorityBlockingQueue<>(10, Comparator.reverseOrder());
        var sevice = Executors.newFixedThreadPool(20);

        for(int i  = 0; i < 10; i++) {
            final int index = i;
            sevice.execute(() -> {
                try {
                    Thread.sleep(1000);
                    integerPriorityQueue.put(index);
                    System.out.println("succes input data ");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        sevice.execute(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                    int data = integerPriorityQueue.take();
                    System.out.println("receive data-"+data);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        sevice.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void delaySchedule() throws InterruptedException {
        var delay = new DelayQueue<ScheduledFuture<String>>();
        var sevice = Executors.newFixedThreadPool(20);
        var schedula = Executors.newScheduledThreadPool(10);

        for(int i = 0; i < 10; i++) {
            final var index = i;
            delay.put(schedula.schedule(() ->  "data"+index, 1, TimeUnit.SECONDS));
        }

        sevice.execute(() -> {
            while (true) {
                try {
                    var value =  delay.take();
                    System.out.println("receive data = " + value.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        sevice.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void synceChron() throws InterruptedException {
        var queue = new SynchronousQueue<String>();
        var service = Executors.newFixedThreadPool(20);

        for(int i = 0; i< 10; i++) {
            var index =i ;
           service.execute(() -> {
               try {
                   queue.put("data" + index);
                   System.out.println("succes input data" + index);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           });
        }

        service.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    var value = queue.take();
                    System.out.println("receive date " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void blockingDeque() throws InterruptedException { // mendukung fifo dan lilo
        // input a yang keluar pertama a
        BlockingDeque<String> deque = new LinkedBlockingDeque<>();
        var service = Executors.newFixedThreadPool(10);

        for(int i = 0; i< 10; i++) {
            var index = i;
            service.execute(() -> {
                try {
                    deque.put("data-"+index);
                    System.out.println("succes input data" + index);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        service.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    var value = deque.take();
                    System.out.println("receive = " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void tranferQue() {
        // pengirim akan menunggu sampai ada penerima
        TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
        var service = Executors.newFixedThreadPool(10);

        for(int i = 0; i< 10; i++) {
          var index = i;
          service.execute(() -> {
              try {
                  transferQueue.transfer("date-"+index);
                  System.out.println("succes input date");
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }
          });
        }

        service.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);
                    var value =transferQueue.take();
                    System.out.println("receive : " + value);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }
}
