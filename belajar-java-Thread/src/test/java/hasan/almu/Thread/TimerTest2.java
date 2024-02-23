package hasan.almu.Thread;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest2 {

    @Test
    void timerE() throws InterruptedException {
        var say = new TimerTask() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };

        var timer1 = new Timer();
        timer1.schedule(say, 2000, 1000);

        Thread.sleep(5000);
    }
}
