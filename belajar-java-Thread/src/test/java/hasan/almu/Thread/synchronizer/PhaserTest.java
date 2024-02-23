package hasan.almu.Thread.synchronizer;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest { //DYNAMIC

    @Test
    void pharseAsCount() throws InterruptedException {
        Phaser phaser = new Phaser();
        var service = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);
        phaser.bulkRegister(5); //total nya menjadi sepuluh
        for(int i = 0; i < 5; i++) {
            service.execute(() -> {
                try {
                    System.out.println("start task");
                    Thread.sleep(2000);
                    System.out.println("end task");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    phaser.arrive();
                }
            });
        }

        service.execute(() -> {
            phaser.awaitAdvance(0);
            System.out.println("finish all task");
        });

        service.awaitTermination(1, TimeUnit.MINUTES);
    }

    @Test
    void pharseAsCyc() throws InterruptedException { //alternative , dynamic
        Phaser phaser = new Phaser();
        var exe = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);
        for(int i =0 ; i < 5; i++) {
            exe.execute(() -> {
                phaser.arriveAndAwaitAdvance();
                System.out.println("done waiting");
            });
        }

        exe.awaitTermination(1, TimeUnit.MINUTES);
    }
}
