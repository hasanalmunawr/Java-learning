package hasan.almu.Thread;

public class DiamondApp {

    public static void main(String[] args) {
        var thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                System.out.println("Run Thread");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(false);
        thread.start();
    }
}
