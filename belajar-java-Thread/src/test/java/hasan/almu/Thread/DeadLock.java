package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

public class DeadLock {

//    DeadLock hanya bisa di atasi dengan manual yaitu mencari letak logic yang salah pada kode nya.
    @Test
    void deadLockTest() throws InterruptedException {
        var balance1 = new BalanceDeadLock(10000);
        var balance2 = new BalanceDeadLock(10000);

        var thread1 = new Thread(() -> {
            try {
                balance1.transverSolution(balance1, balance2, 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        var thread2 = new Thread(() -> {
            try {
                balance1.transverSolution(balance2, balance1, 5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
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
