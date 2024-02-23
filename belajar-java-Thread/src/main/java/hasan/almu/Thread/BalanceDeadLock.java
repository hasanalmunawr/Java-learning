package hasan.almu.Thread;

public class BalanceDeadLock {

    private int value = 0;


    public BalanceDeadLock(int value) {
        this.value = value;
    }

    public void setBalance(int balance) {
        this.value = balance;
    }

    public int getBalance() {
        return value;
    }

    public  void transver(BalanceDeadLock from, BalanceDeadLock to, int value) throws InterruptedException {
        synchronized (from) {
            Thread.sleep(1000);
            synchronized (to) {
                Thread.sleep(1000);
                from.setBalance(from.getBalance() - value);
                to.setBalance(to.getBalance() + value);
            }
        }
    }
    public  void transverSolution(BalanceDeadLock from, BalanceDeadLock to, int value) throws InterruptedException {
        synchronized (from) {
            Thread.sleep(1000);
            from.setBalance(from.getBalance() - value);
        }
        synchronized (to) {
            Thread.sleep(1000);
            to.setBalance(to.getBalance() + value);
        }
    }
}
