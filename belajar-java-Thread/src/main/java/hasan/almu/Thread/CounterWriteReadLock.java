package hasan.almu.Thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class CounterWriteReadLock {

    private long value = 0l;

    final private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void increment() {
        try {
            lock.writeLock().lock();
            value++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public long getValue() {
        try {
            lock.readLock().lock();
            return value;
        } finally {
            lock.readLock().unlock();
        }
    }
}
