package concurrency;

/**
 * Example of creating a thread by extending Thread.
 *
 * Less flexible because Java supports only single inheritance.
 * Usually implementing Runnable is preferred.
 */
public class MyThreadClass extends Thread {

    public MyThreadClass(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            System.out.println(
                    "[Thread Class] " +
                            getName() +
                            " -> START");

            Thread.sleep(1000);

            System.out.println(
                    "[Thread Class] " +
                            getName() +
                            " -> END");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}