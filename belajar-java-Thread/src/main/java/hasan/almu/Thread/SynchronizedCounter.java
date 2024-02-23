package hasan.almu.Thread;

public class SynchronizedCounter {


    private long value = 0l;

    public synchronized void incrument() {
        synchronized (this) {
            value++;
        }
    }

    public long getValue() {
        return value;
    }
}
