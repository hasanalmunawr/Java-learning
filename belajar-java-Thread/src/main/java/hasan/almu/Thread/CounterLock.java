package hasan.almu.Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {

    private long value = 0l;

    final private Lock lock = new ReentrantLock();
    public void incrument() {
       try {
           lock.lock();
           value++;
       } finally {
           lock.unlock();
       }
    }

    public long getValue() {
        return value;
    }
}
