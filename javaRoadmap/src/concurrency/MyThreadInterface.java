package concurrency;

public interface MyThreadInterface extends Runnable {
    @Override
    public default void run(){
        try {
            System.out.println(Thread.currentThread().getName() + " - Thread Start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " - Thread End");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
