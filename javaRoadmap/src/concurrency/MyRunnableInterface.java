package concurrency;

/**
 * Demonstrates implementing Runnable via an interface.
 *
 * Runnable separates:
 *   - Task (Runnable)
 *   - Execution mechanism (Thread)
 *
 * This is generally preferred over extending Thread.
 */
public interface MyRunnableInterface extends Runnable {

    @Override
    default void run() {
        try {
            System.out.println(
                    "[Runnable Interface] " +
                            Thread.currentThread().getName() +
                            " -> START");

            Thread.sleep(1000);

            System.out.println(
                    "[Runnable Interface] " +
                            Thread.currentThread().getName() +
                            " -> END");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}