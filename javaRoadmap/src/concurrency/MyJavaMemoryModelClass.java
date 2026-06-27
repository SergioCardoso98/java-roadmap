package concurrency;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyJavaMemoryModelClass implements Runnable {

    // Shared across ALL threads (dangerous without synchronization)
    private final ArrayList<Integer> sharedList;

    // Each thread has its own copy (safe)
    private final ArrayList<Integer> localList = new ArrayList<>();

    // Primitive copied per thread at construction time
    private int threadInitialCounter;

    // Shared atomic counter (thread-safe)
    private final AtomicInteger sharedAtomicCounter;

    // Thread-local counter (each Runnable instance has its own value)
    private int threadLocalCounter;

    public MyJavaMemoryModelClass(
            ArrayList<Integer> sharedList,
            int initialCounterValue,
            AtomicInteger sharedAtomicCounter) {

        this.sharedList = sharedList;
        this.threadInitialCounter = initialCounterValue;
        this.sharedAtomicCounter = sharedAtomicCounter;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.println("\n========== " + threadName + " START ==========");

        // Shared mutable list (NOT thread-safe)
                System.out.println(threadName + " | sharedList identity: " +
                        System.identityHashCode(sharedList));

        // Thread-local list (safe, not shared)
                System.out.println(threadName + " | localList identity: " +
                        System.identityHashCode(localList));

        // Shared atomic counter
                System.out.println(threadName + " | sharedAtomicCounter identity: " +
                        System.identityHashCode(sharedAtomicCounter));

        // Primitive copied per thread (boxed for identity check)
                System.out.println(threadName + " | threadInitialCounter value: " +
                        threadInitialCounter + " | identity: " +
                        System.identityHashCode(threadInitialCounter));

        // Thread-local counter (each Runnable instance has its own value)
                System.out.println(threadName + " | threadLocalCounter value: " +
                        threadLocalCounter + " | identity: " +
                        System.identityHashCode(threadLocalCounter));

        // Runnable instance itself (each thread runs its own object instance)
                System.out.println(threadName + " | Runnable instance identity: " +
                        System.identityHashCode(this));

        System.out.println("---------- " + threadName + " executing ----------");

        for (int i = 0; i < 5; i++) {

            // Thread-local counter
            threadLocalCounter++;

            // Primitive copy per thread
            threadInitialCounter++;

            // shared counter
            sharedAtomicCounter.incrementAndGet();

            System.out.println(threadName + " step " + i);

            System.out.println("   threadLocalCounter = " + threadLocalCounter);

            System.out.println("   threadInitialCounter (thread copy) = " + threadInitialCounter);

            System.out.println("   sharedAtomicCounter = " + sharedAtomicCounter);
        }

        System.out.println("========== " + threadName + " END ==========\n");
    }
}