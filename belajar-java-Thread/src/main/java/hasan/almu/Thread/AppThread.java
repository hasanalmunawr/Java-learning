package hasan.almu.Thread;

/**
 * Hello world!
 *
 */
public class AppThread
{
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        String nameThread = Thread.currentThread().getName();

        System.out.println(thread);
        System.out.println(nameThread);
    }
}
