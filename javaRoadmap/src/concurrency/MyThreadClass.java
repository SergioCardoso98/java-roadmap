package concurrency;

public class MyThreadClass extends Thread{
    public MyThreadClass(String name) {
        super(name);
    }
    public void run(){
        try {
            System.out.println(Thread.currentThread().getName() + " - Thread Start");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " - Thread End");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
