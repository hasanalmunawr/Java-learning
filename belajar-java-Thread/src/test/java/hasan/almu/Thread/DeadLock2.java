package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

public class DeadLock2 {
    @Test
    void testcreate() throws InterruptedException {
        var balance1 = new BalanceDeadLock(50000);
        var balance2 = new BalanceDeadLock(50000);

        var thread1 = new Thread(() -> {
            try {
                balance1.transverSolution(balance1, balance2, 30000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        var thread2 = new Thread(() -> {
            try {
                balance2.transverSolution(balance2, balance1, 4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(balance1.getBalance());
        System.out.println(balance2.getBalance());
    }
}
