import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import intermediatemodules.module;
import basics.*;
import basics.Arrays;
import moreoop.*;
import intermediate.*;
import concurrency.*;

public class Main {
    public static void main(String[] args){
        //runBasics(1);
        //runMoreoop(1);
        /*try{//For the module = 1; the method can throw checked and unchecked exceptions
            runIntermediate(7);
        }catch (ExceptionHandling_Checked_NumberValidator | ExceptionHandling_Unchecked_NumberValidator e){// Catches both checked (compile-time enforced) and unchecked (runtime) exceptions using multi-catch
            //And since I'm catching the checked exception here in main, I don't need the "throws ExceptionHandling_Checked_NumberValidator" in the method "public static void main(String[] args)"
            e.printStackTrace();
        }*/
        //runConcurrency();
        //runVirtualThreads();
        //runJavaMemoryModel();
        runVolatileAndSynchronized();
    }
    public static void runBasics(){
        BasicSyntax bs = new BasicSyntax(); //Creates an instance of BasicSyntax class
        TypeCasting tc = new TypeCasting(); //Creates an instance of TypeCasting class
        MathOperations mo = new MathOperations(); //Creates an instance of MathOperations class
        Arrays arr = new Arrays(); //Creates an instance of Arrays class
        ConditionalAndLoops cal = new ConditionalAndLoops(); //Creates an instance of ConditionalAndLoops class

        OopBasics oopb = new OopBasics(); //Creates an OopBasics object using default constructor
        OopBasics oopb2 = new OopBasics(1, "custom string", 1.00F); //Creates an OopBasics object using parameterized constructor
        oopb.print_object(); //Calls print_object method on first object
        oopb2.print_object(); //Calls print_object method on second object
        OopBasics.static_method(); //Calls static method directly from the class (no object needed)
    }
    public static void runMoreoop(int module){
        //ObjectLifeCycle
        if(module == 1) {
            // 🟢 CREATION (heap allocation + constructor runs)
            ObjectLifeCycle obj = new ObjectLifeCycle("SOME_ATTRIBUTE");
            System.out.println("CREATED → attr: " + obj.attr + " | ref: " + obj);
            // 🔵 IN USE (reachable object)
            obj.attr = "CHANGED_ATTRIBUTE";
            System.out.println("IN USE (we changed the attr) → " + obj.getAttr() + " | ref: " + obj);
            // 🔴 UNREACHABLE (lost reference)
            obj = null;
            System.out.println("UNREACHABLE → object lost reference" + " | ref: " + obj);
            // ⚫ GC (automatic cleanup later)
            System.out.println("COLLECTED -> JVM will remove unreachable heap object automatically");
        }
        //MethodChaining
        if(module == 2){
            MethodChaining mco = new MethodChaining("I have a", "surprise for you, here: "); //Creates a MethodChaining object with two attributes
            System.out.println("Method chaining is when a method returns the same object (this), so you can call another method immediately on it."); //Explains method chaining concept
            System.out.println("System.out.println(mco.printBothAttr().addSmile()) = "); //Shows example of method chaining syntax
            System.out.println(mco.printBothAttr().addSmile()); //Calls printBothAttr then immediately calls addSmile using method chaining
            System.out.println("Without method chaining would be"); //Introduces non-chaining version
            System.out.println("System.out.println(mco.printBothAttr() + mco.addSmile())"); //Shows alternative-style example
            System.out.println(mco.printBothAttr() + mco.addSmile()); //Calls methods separately and concatenates results
        }
        //Enums
        if (module == 3){
            Enums enumObject = new Enums("This is my 1st enum object", Enums.EnumsType.ENUM1);// Creates a new Enums object with a name and enum type
            System.out.println(enumObject.enumObjectName);//Prints the name of the enum object
            System.out.println(enumObject.enumType);// Prints the enum constant (ENUM1 in this case)
        }
        //Records
        if (module == 4){
            Records rec = new Records("record1"); //Creates a Records object using custom constructor with only 1 parameter
            Records rec2 = new Records("record2", 100, 100.00F); //Creates a Records object using full constructor with all fields
            System.out.println("record1 embedded Method toString() -> " + rec.toString()); //Calls automatically generated toString() method from record
            System.out.println("record2 embedded Method toString() -> " + rec2.toString()); //Calls automatically generated toString() method from record
            System.out.println("record2 custom Method customMethod() -> " + rec2.customMethod()); //Calls user-defined method inside record
            System.out.println("record2 embedded Method equals() -> " + rec2.equals(rec)); //Calls automatically generated equals() method to compare two record objects
        }
        //initializer block
        if (module == 5){
            InitializerBlock ib1 = new InitializerBlock(); //Creates first object, initializer block runs automatically before constructor
            InitializerBlock ib2 = new InitializerBlock(); //Creates second object, initializer block runs again for this new instance
            InitializerBlock ib3 = new InitializerBlock(); //Creates third object, initializer block runs again for this new instance
        }
        //Inheritance + Abstraction + Encapsulation + Interfaces + Method Overloading/Overriding + Static/Dynamic Binding + Pass-by-value
        if (module == 6){
            // JAVA PARAMETER PASSING RULE:
            // Java is ALWAYS pass-by-value.
            // For primitives (int, boolean, etc.): the actual value is copied, so changes inside methods do NOT affect the original variable.
            // For objects: the VALUE of the reference (memory address) is copied, NOT the object itself.
                // This means both variables point to the same object, so modifying object fields inside a method WILL affect the original object.
                // HOWEVER, reassigning the reference inside the method (e.g. c = new Object()) does NOT affect the original reference outside.
            // Key idea: Java never passes the original variable itself, only a copy of its value (even when that value is a reference).
            OOPConcepts_SubClass_Cat cat = new OOPConcepts_SubClass_Cat("Gato", 1, true); // create Cat object (name, age, alive state)
            System.out.println(cat.getName() + " with " + cat.getAge() + " years says: " + cat.talk()); // print initial state (name, age, behavior)
            cat.setAge(70); // update age (will be capped by MAX_AGE logic in setter)
            System.out.println(cat.getName() + " with " + cat.getAge() + " years says: " + cat.talk()); // print updated state after validation
            cat.setName("seven"); // calling overloaded method
            System.out.println(cat.getName() + " with " + cat.getAge() + " years says: " + cat.talk()); // print updated state after validation
            System.out.println("Is cat alive? " + cat.alive()); // call interface method to check if animal is alive
        }
    }
    public static void runIntermediate(int module) throws ExceptionHandling_Checked_NumberValidator {// Method declaration; 'throws' is required for checked exceptions because compiler enforces handling
        if (module == 1){
            Scanner sc = new Scanner(System.in);
            while (true){

                System.out.print("Enter a number from 1 - 10: ");
                int number = sc.nextInt();
                if (number == 30){// Checks for a special invalid case
                    //Despite not catching the exception, I don't need the "throws ExceptionHandling_Unchecked_NumberValidator" because is unchecked Exception
                    throw new ExceptionHandling_Unchecked_NumberValidator("Special exception for number 30"); // Throws an unchecked exception (RuntimeException); compiler does not force handling
                }
                if (number < 1 || number > 10){
                    //Need the "throws ExceptionHandling_Checked_NumberValidator" in the method because I'm not catching the exception ExceptionHandling_Checked_NumberValidator
                    throw new ExceptionHandling_Checked_NumberValidator("Number not between 1 - 10");// Throws a checked exception; compiler requires try-catch or throws declaration
                }
            }
        }
        if (module == 2){
            // Traditional anonymous class. Here we manually create an implementation of the Runnable interface
            // We must explicitly write: new Runnable() -> override the run() method -> provide full method structure (boilerplate code)
            Runnable leTraditional = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello");// This is the actual code that runs when run() is called
                }
            };
            // Lambda expression version. This is a shorter way to implement the same Runnable interface
            // Java automatically knows we are implementing run() because Runnable has only ONE abstract method (functional interface rule)
            // The lambda here means: "When run() is called, execute System.out.println("Hello")"
            Runnable leLambda = () -> System.out.println("Hello");

            //My custom interface to use a lambda expression on, is the same as above but I implemented it
            LambdaExpressions leCustom = () -> System.out.println("Hello");

            // All do the same thing — just different syntax styles
            leTraditional.run(); // executes anonymous class implementation
            leLambda.run();// executes anonymous class implementation
            leCustom.run();//executes anonymous class implementation

            //https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html
        }
        if (module == 3){
            try {
                // creates object → validation runs → should PASS (only stringAttr is null but NOT annotated)
                Annotations objectWithValidNull = new Annotations(null, "attr2", "attr3");
                // method calls after successful creation
                objectWithValidNull.deprecatedSayHelloMethod();
                objectWithValidNull.suppressedDeprecatedSayHelloMethod();
                objectWithValidNull.sayHelloMethod();
                // creates object → validation runs → FAILS because annotated fields are null
                Annotations objectWithInvalidNull = new Annotations(null, null, null);
            } catch (InputMismatchException | IllegalAccessException e) {
                // catches validation failure or reflection error
                System.out.println("Object not created because nulls detected in @CustomAnnotationNotnull fields");
            }
        }
        if (module == 4){
            intermediatemodules.module.main(); //comments explaining this is on the Module itself, this just runs it
        }
        if (module == 5){
            Optional<OptionalDisplayObject> do1 = Optional.of(new OptionalDisplayObject("object1", 10)); // create Optional containing a value (never null here)
            Optional<OptionalDisplayObject> do2 = Optional.ofNullable(null); // create empty Optional (value is null so becomes Optional.empty)

            System.out.println("do1.isPresent(): "+ do1.isPresent()); // true because do1 contains a value
            System.out.println("do2.isPresent(): "+ do2.isPresent()); // false because do2 is empty
            System.out.println("do1.get().attrString + do1.get().attrInt: "+do1.get().attrString + "/" + do1.get().attrInt); // safely using get() because value exists
            try{do2.orElseThrow();}catch(Exception e){System.out.println("do2.orElseThrow(): exception thrown because do2 is empty (no value present)");} // throws NoSuchElementException since Optional is empty
            System.out.println("do1.orElse(new OptionalDisplayObject(\"UNKNOWN\", 0)): "); // orElse is called but result is ignored (does NOT modify do1)
            do1.orElse(new OptionalDisplayObject("UNKNOWN", 0)); // fallback is evaluated but discarded since do1 already has value
            System.out.println("    - do1.get().attrString + do1.get().attrInt: "+do1.get().attrString + "/" + do1.get().attrInt); // still original value because do1 was never changed
            System.out.println("do2 = Optional.of(do2.orElse(new OptionalDisplayObject(\"UNKNOWN\", 0)))"); // attempt to replace empty Optional with fallback wrapped in Optional
            do2 = Optional.of(do2.orElse(new OptionalDisplayObject("UNKNOWN", 0))); // do2 becomes non-empty Optional containing fallback value
            System.out.println("    - do2.get().attrString + do2.get().attrInt: "+do2.get().attrString + "/" + do2.get().attrInt); // now safe: prints fallback values
        }
        if (module == 6){
            // Create the dependency object (this is the "service" that will be injected)
            DependencyInjection_Injection injection =
                    new DependencyInjection_Injection("a", "b", "c");
            // Create the dependant object and INJECT the dependency via constructor
            DependencyInjection_Dependant dependant =
                    new DependencyInjection_Dependant(injection);
            // Print the original dependency object directly
            System.out.println("[Directly printing Injection object]");
            injection.printInjection();
            // Print the dependant, which uses the injected object internally
            System.out.println("\n[Printing from Dependant (using injected object)]");
            dependant.printDependant();
        }
        if (module == 7){
            //These objects are just used so that in the class it falls under the correct if
            //The class creates its own object to demonstrate
            Stack<String> stackCollection = new Stack<String>();
            ArrayList<String> arrayListCollection = new ArrayList<>();
            Iterator<String> iteratorCollection = arrayListCollection.iterator();
            Queue<Integer> queueCollection = new ArrayDeque<>();
            Deque<Integer> dequeCollection = new ArrayDeque<>();
            Set<Integer> setCollection = new HashSet<>();
            Map<String, Integer> mapCollection = new HashMap<>();
            int[] arrayCollection = {1, 2, 3};

            CollectionsWrapper<Stack> stackCollectionsWrapper = new CollectionsWrapper<>(stackCollection);
            stackCollectionsWrapper.displayCollection();

            CollectionsWrapper<Iterator> iteratorCollectionsWrapper = new CollectionsWrapper<>(iteratorCollection);
            iteratorCollectionsWrapper.displayCollection();

            CollectionsWrapper<Queue> queueCollectionsWrapper = new CollectionsWrapper<>(queueCollection);
            queueCollectionsWrapper.displayCollection();

            CollectionsWrapper<Deque> dequeCollectionsWrapper = new CollectionsWrapper<>(dequeCollection);
            dequeCollectionsWrapper.displayCollection();

            CollectionsWrapper<Set> setCollectionsWrapper = new CollectionsWrapper<>(setCollection);
            setCollectionsWrapper.displayCollection();

            CollectionsWrapper<Map> mapCollectionsWrapper = new CollectionsWrapper<>(mapCollection);
            mapCollectionsWrapper.displayCollection();

            CollectionsWrapper<ArrayList> arrayListCollectionWrapper = new CollectionsWrapper<>(arrayListCollection);
            arrayListCollectionWrapper.displayCollection();

            CollectionsWrapper<int[]> arrayCollectionsWrapper = new CollectionsWrapper<>(arrayCollection);
            arrayCollectionsWrapper.displayCollection();
        }

    }
    public static void runConcurrency() {
        /**
         * Demonstrates several ways to create and manage threads in Java:
         *
         * 1. Extending Thread
         * 2. Implementing Runnable
         * 3. Anonymous Runnable class
         * 4. Lambda Runnable
         * 5. Gracefully stopping a thread
         * 6. Daemon threads
         */
        // ==========================================================
        // 1. CREATE THREAD BY EXTENDING THREAD CLASS
        // ==========================================================
        MyThreadClass classThread = new MyThreadClass("classThread");
        classThread.start(); // Creates a new thread and executes run()

        // ==========================================================
        // 2. CREATE THREAD USING A CLASS IMPLEMENTING RUNNABLE
        // ==========================================================
        Thread interfaceThread =
                new Thread(new MyRunnableInterface() {}, "interfaceThread");
        interfaceThread.start();

        // ==========================================================
        // 3. CREATE THREAD USING AN ANONYMOUS RUNNABLE CLASS
        // ==========================================================
        Runnable runnableFunc = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(
                            "[Anonymous Runnable] " +
                                    Thread.currentThread().getName() +
                                    " -> START");

                    Thread.sleep(1000);

                    System.out.println(
                            "[Anonymous Runnable] " +
                                    Thread.currentThread().getName() +
                                    " -> END");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread runnableThread =
                new Thread(runnableFunc, "runnableThread");
        runnableThread.start();

        // ==========================================================
        // 4. CREATE THREAD USING A LAMBDA EXPRESSION
        // ==========================================================
        Runnable runnableLambdaFunc = () -> {
            try {
                System.out.println(
                        "[Lambda Runnable] " +
                                Thread.currentThread().getName() +
                                " -> START");

                Thread.sleep(1000);

                System.out.println(
                        "[Lambda Runnable] " +
                                Thread.currentThread().getName() +
                                " -> END");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread runnableLambdaThread =
                new Thread(runnableLambdaFunc, "runnableLambdaThread");
        runnableLambdaThread.start();

        // ==========================================================
        // WAIT FOR ALL THREADS TO FINISH
        //
        // join() blocks the current thread (main thread here)
        // until the target thread has completed execution.
        // ==========================================================
        try {
            classThread.join();
            interfaceThread.join();
            runnableThread.join();
            runnableLambdaThread.join();

            System.out.println(
                    "[MAIN] All worker threads have completed.");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // ==========================================================
        // 5. GRACEFULLY STOPPING A THREAD
        //
        // Never use Thread.stop() (deprecated and unsafe).
        // Instead use a shared flag that the thread checks.
        // ==========================================================
        try {
            MyStoppableRunnable stoppableRunnable =
                    new MyStoppableRunnable();

            Thread stoppableThread =
                    new Thread(stoppableRunnable, "stoppableThread");

            stoppableThread.start();

            // Allow the thread to run for 3 seconds
            Thread.sleep(3000);

            // Ask the thread to stop
            stoppableRunnable.requestStop();

            // Wait for it to finish
            stoppableThread.join();

            System.out.println(
                    "[MAIN] Stoppable thread terminated.");
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // ==========================================================
        // 6. DAEMON THREAD
        //
        // Daemon threads run in the background.
        // JVM exits automatically when only daemon threads remain.
        // ==========================================================
        Runnable daemonRunnable = () -> {
            try {
                System.out.println(
                        "[Daemon] " +
                                Thread.currentThread().getName() +
                                " -> START");

                while (true) {
                    Thread.sleep(500);

                    System.out.println(
                            "[Daemon] " +
                                    Thread.currentThread().getName() +
                                    " -> RUNNING");
                }
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread daemonThread =
                new Thread(daemonRunnable, "daemonThread");

        try {
            daemonThread.setDaemon(true); // Must be called before start()
            daemonThread.start();

            // Main thread stays alive for 5 seconds
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(
                "[MAIN] Main thread finished. JVM will now terminate, " +
                        "stopping the daemon thread automatically.");
    }
    public static void runVirtualThreads() {
        // ==========================================================
        // VIRTUAL THREADS (Project Loom)
        //
        // Virtual threads are lightweight threads managed by the JVM.
        // Unlike platform threads, you can create thousands or even
        // millions of them with very little overhead.
        //
        // This example:
        //
        // 1. Creates multiple virtual threads
        // 2. Assigns each thread a name
        // 3. Starts all threads
        // 4. Waits for all threads to finish using join()
        // ==========================================================

        List<Thread> virtualThreads = new ArrayList<>();

        int numberOfVirtualThreads = 20;

        // ==========================================================
        // TASK EXECUTED BY EACH VIRTUAL THREAD
        // ==========================================================
        Runnable virtualThreadTask = () -> {

            System.out.println(
                    "[Virtual Thread] " +
                            Thread.currentThread().getName() +
                            " -> START");

            try {
                // Simulate some work
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(
                    "[Virtual Thread] " +
                            Thread.currentThread().getName() +
                            " -> END");
        };
        // ==========================================================
        // CREATE ALL VIRTUAL THREADS
        //
        // Threads are created in an unstarted state and stored
        // in a collection for later execution.
        // ==========================================================
        for (int i = 0; i <= numberOfVirtualThreads; i++) {

            Thread virtualThread =
                    Thread.ofVirtual()
                            .name("virtualThread-" + i)
                            .unstarted(virtualThreadTask);

            virtualThreads.add(virtualThread);
        }

        // ==========================================================
        // START ALL VIRTUAL THREADS
        // ==========================================================
        for (Thread virtualThread : virtualThreads) {
            virtualThread.start();
        }

        // ==========================================================
        // WAIT FOR ALL VIRTUAL THREADS TO COMPLETE
        //
        // join() blocks the current thread until the target
        // virtual thread has finished execution.
        // ==========================================================
        for (Thread virtualThread : virtualThreads) {
            try {
                virtualThread.join();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(
                "[MAIN] All virtual threads have completed.");
    }
    public static void runJavaMemoryModel(){
        //See images in file concurrency for more context

        // Shared mutable object (NOT thread-safe)
        ArrayList<Integer> sharedList = new ArrayList<>();

        // Primitive value passed into threads (copied, not shared)
        int initialCounterValue = 0;

        // Thread-safe shared counter
        AtomicInteger sharedAtomicCounter = new AtomicInteger(0);

        Runnable task1 = new MyJavaMemoryModelClass(sharedList, initialCounterValue, sharedAtomicCounter);
        Runnable task2 = new MyJavaMemoryModelClass(sharedList, initialCounterValue, sharedAtomicCounter);

        Thread thread1 = new Thread(task1, "Thread-1");
        Thread thread2 = new Thread(task2, "Thread-2");

        thread1.start();
        thread2.start();
        }
    public static void runVolatileAndSynchronized() {
        System.out.println("#### Volatile Key Word demonstration ###");
        MyVolatileClass volatileObject = new MyVolatileClass(); // shared object used by both threads
        Thread threadSetter = new Thread(new MyVolatileSetterRunnableClass(volatileObject), "ThreadSetter"); // writer thread modifies shared state
        Thread threadGetter = new Thread(new MyVolatileGetterRunnableClass(volatileObject), "ThreadGetter"); // reader thread observes shared state
        threadGetter.start(); // start reader first to increase chance of partial reads
        threadSetter.start(); // start writer second
    }
}