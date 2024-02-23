package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TImerTest {

    @Test
    void delayedJobs() throws InterruptedException {
        var timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("delayed Jobs");
            }
        };

        var timer = new Timer();
        timer.schedule(timerTask, 3000l);

        Thread.sleep(5000);
    }

    @Test
    void period() throws InterruptedException {
        var timertask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("woi bangun");
            }
        };

        var timer = new Timer();
        timer.schedule(timertask, 3000l, 2000l);

        Thread.sleep(10000);
    }
}
