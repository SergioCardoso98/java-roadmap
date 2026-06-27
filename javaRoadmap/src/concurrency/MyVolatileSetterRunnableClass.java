package concurrency;

public class MyVolatileSetterRunnableClass implements Runnable {
    private final MyVolatileClass volatileObject;
    public MyVolatileSetterRunnableClass(MyVolatileClass volatileObject) {
        this.volatileObject = volatileObject; // shared object reference passed explicitly
    }
    @Override
    public void run() {
        int incrementor = 0;
        for (int i = 0; i <= 10; i++) {
            incrementor++;
            volatileObject.volatileSetter(incrementor, incrementor, incrementor); // updates shared state
            // Not an atomic snapshot: each getter is a separate memory read
            // varB is volatile and acts as the synchronization point
            // WRITE side: CPU flushes previous writes (varA) to main memory before writing varB
                // - all writes BEFORE varB was written in ThreadSetter become visible here (including varA)
            // READ side: reading varB forces a refresh from main memory (acquire barrier)
                // - BUT writes AFTER varB (like varC) are NOT guaranteed to be visible yet
            // This guarantees visibility of writes before varB (varA), but not after it (varC)
            // So this line does NOT read a single consistent "moment in time", it reads 3 separate values
            System.out.printf(
                    "%s iteration[%s] Values(%d, %d, %d)%n",
                    Thread.currentThread().getName(),
                    i,
                    volatileObject.volatileGetterA(),
                    volatileObject.volatileGetterB(),
                    volatileObject.volatileGetterC()
            ); // prints current snapshot of shared memory
            try {
                Thread.sleep(100); // slows down loop so threads interleave more clearly
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupt status
                return;
            }
        }
    }
}