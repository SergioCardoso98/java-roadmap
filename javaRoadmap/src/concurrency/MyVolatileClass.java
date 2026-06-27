package concurrency;

public class MyVolatileClass {
    private int varA = 0;
    private volatile int varB = 0; // volatile guarantees visibility + prevents reordering around this variable
    private int varC = 0;
    public void volatileSetter(int a, int b, int c) {
        try {
            this.varA = a; // normal write, not visible immediately to other threads
            Thread.sleep(10); // forces timing gaps so race conditions become easier to observe
            this.varB = b; // volatile write acts as a memory barrier (release) so everything before it becomes visible
            Thread.sleep(10); // increases chance that another thread observes intermediate state
            this.varC = c; // normal write after volatile, not guaranteed to be visible when reading varB
            // important idea:
            // JVM and CPU may reorder independent instructions for performance
            // volatile prevents reordering across varB only
            // so varA is guaranteed to be visible before varB
            // but varC is NOT guaranteed because it happens after the volatile write
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // restore interrupt flag if thread is interrupted
        }
    }
    public int volatileGetterA() {
        return this.varA; // plain read, no synchronization guarantee
    }
    public int volatileGetterB() {
        return this.varB; // volatile read forces latest value from main memory
    }
    public int volatileGetterC() {
        return this.varC; // plain read, may be stale depending on timing
    }
}