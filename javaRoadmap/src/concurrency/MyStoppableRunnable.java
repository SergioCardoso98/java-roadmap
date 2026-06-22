package concurrency;

/**
 * Demonstrates how to stop a thread gracefully.
 *
 * A shared flag is checked repeatedly by the worker thread.
 * When the flag becomes true, the loop exits naturally.
 */
public class MyStoppableRunnable implements Runnable {

    /**
     * Indicates whether the thread should stop.
     */
    private boolean stopRequested = false;

    /**
     * Called by another thread (usually main)
     * to request termination.
     *
     * synchronized ensures visibility and
     * thread-safe access to stopRequested.
     */
    public synchronized void requestStop() {
        System.out.println(
                "[STOP REQUEST] Sent by thread: "
                        + Thread.currentThread().getName());

        stopRequested = true;
    }

    /**
     * Returns whether a stop was requested.
     */
    public synchronized boolean isStopRequested() {
        return stopRequested;
    }

    @Override
    public void run() {

        System.out.println(
                "[Stoppable Runnable] "
                        + Thread.currentThread().getName()
                        + " -> START");

        try {

            while (!isStopRequested()) {

                System.out.println(
                        "[Stoppable Runnable] "
                                + Thread.currentThread().getName()
                                + " -> WORKING");

                Thread.sleep(1000);
            }

            System.out.println(
                    "[Stoppable Runnable] "
                            + Thread.currentThread().getName()
                            + " -> STOP REQUEST RECEIVED");

            System.out.println(
                    "[Stoppable Runnable] "
                            + Thread.currentThread().getName()
                            + " -> END");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}