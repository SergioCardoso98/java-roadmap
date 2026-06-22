package intermediate;

import java.util.*;

public class CollectionsWrapper<T> {
    private T generic;

    public CollectionsWrapper(T generic){
        this.generic = generic;
    }

    public void displayCollection(){
        if (this.generic instanceof Stack){
            /*A stack is a fundamental data structure that follows the Last-In, First-Out (LIFO) principle.
            Imagine a stack of plates; you can only add or remove plates from the top.
            This means the last element added to the stack is the first one to be removed.
            Stacks are used to manage function calls, evaluate expressions, and implement undo/redo functionality*/
            System.out.println("--- Collection [Stack] ---");
            Stack<Integer> stack_demonstration = new Stack();
            System.out.println("    - Creating stack of Integers do demonstrate: Stack<Integer> stack_demonstration = new Stack();");
            stack_demonstration.push(1);
            stack_demonstration.push(2);
            stack_demonstration.push(3);
            //stack_demonstration.push("A");
            System.out.println("    - Pushing items into the stack: stack_demonstration.push(1);");
            System.out.println("    - Pushing items into the stack: stack_demonstration.push(2);");
            System.out.println("    - Pushing items into the stack: stack_demonstration.push(3);");
            System.out.println("    - Can't push a String since I declared a Integer type stack: stack_demonstration.push('A');");
            System.out.println("    - stack_demonstration = " + stack_demonstration);
            System.out.println("    - Peeking into the item at the top of stack_demonstration with stack_demonstration.peek(): " + stack_demonstration.peek());
            stack_demonstration.pop();
            System.out.println("    - Removing the item at the top of stack_demonstration with stack_demonstration.pop()");
            System.out.println("    - stack_demonstration = " + stack_demonstration);
        }
        if (this.generic instanceof Iterator){
            /*An Iterator is like a finger that points to items in a collection one by one.
              Imagine you have a box of toys, and you want to look at each toy one at a time.
              The Iterator helps you move through the toys without taking them all out at once.

              It can:
              - Check if there is another item -> hasNext()
              - Move to the next item -> next()

              Iterators are useful because they provide a safe and standard way
              to go through elements in collections like Lists, Sets, and Queues.
            */
            System.out.println("--- Collection [Iterator] ---");
            ArrayList<String> iterator_demonstration = new ArrayList<>();
            System.out.println("    - Creating an ArrayList of Strings: ArrayList<String> iterator_demonstration = new ArrayList<>();");
            iterator_demonstration.add("Apple");
            iterator_demonstration.add("Banana");
            iterator_demonstration.add("Orange");
            System.out.println("    - Adding items into the ArrayList: iterator_demonstration.add('Apple');");
            System.out.println("    - Adding items into the ArrayList: iterator_demonstration.add('Banana');");
            System.out.println("    - Adding items into the ArrayList: iterator_demonstration.add('Orange');");
            System.out.println("    - iterator_demonstration = " + iterator_demonstration);
            Iterator<String> iterator = iterator_demonstration.iterator();
            System.out.println("    - Creating an Iterator with: Iterator<String> iterator = iterator_demonstration.iterator();");
            while (iterator.hasNext()) {
                System.out.println("    - iterator.next() = " + iterator.next());
            }
            System.out.println("    - iterator.hasNext() becomes false when there are no more items.");
        }
        if (this.generic instanceof Queue){
            /*A Queue is a fundamental data structure that follows the First-In, First-Out (FIFO) principle.
              Imagine a line of people waiting for a bus; the first person to enter the line
              is the first one to leave it.

              This means the first element added to the queue is the first one to be removed.
              Queues are used in task scheduling, handling requests, and managing waiting lines.
             */
            System.out.println("--- Collection [Queue] ---");
            Queue<Integer> queue_demonstration = new ArrayDeque<>(); //Can also be for example a linkedlist
            System.out.println("    - Creating a Queue of Integers to demonstrate: Queue<Integer> queue_demonstration = new ArrayDeque<>();");
            queue_demonstration.add(1);
            queue_demonstration.add(2);
            queue_demonstration.add(3);
            //queue_demonstration.add("A");
            System.out.println("    - Adding items into the queue: queue_demonstration.add(1);");
            System.out.println("    - Adding items into the queue: queue_demonstration.add(2);");
            System.out.println("    - Adding items into the queue: queue_demonstration.add(3);");
            System.out.println("    - Can't add a String since I declared an Integer type queue: queue_demonstration.add('A');");
            System.out.println("    - queue_demonstration = " + queue_demonstration);
            System.out.println("    - Peeking into the first item of queue_demonstration with queue_demonstration.peek(): "
                    + queue_demonstration.peek());
            queue_demonstration.poll();
            System.out.println("    - Removing the first item of queue_demonstration with queue_demonstration.poll()");
            System.out.println("    - queue_demonstration = " + queue_demonstration);
        }
        if (this.generic instanceof Deque){
                /*A Deque (Double-Ended Queue) is a linear data structure that allows
                  insertion and removal of elements from BOTH ends.

                  Think of it like a line where people can:
                  - enter from the front or back
                  - leave from the front or back

                  This makes it more flexible than a standard Queue (FIFO only).

                  Common use cases:
                  - implementing stacks (LIFO)
                  - implementing queues (FIFO)
                  - sliding window problems
                */
            System.out.println("--- Collection [Deque] ---");
            Deque<Integer> deque_demonstration = new ArrayDeque<>();
            // Can also use LinkedList: Deque<Integer> deque_demonstration = new LinkedList<>();
            System.out.println("    - Creating a Deque of Integers: Deque<Integer> deque_demonstration = new ArrayDeque<>();");
            deque_demonstration.addFirst(1);
            deque_demonstration.addLast(2);
            deque_demonstration.addLast(3);
            System.out.println("    - Adding items:");
            System.out.println("        deque_demonstration.addFirst(1);");
            System.out.println("        deque_demonstration.addLast(2);");
            System.out.println("        deque_demonstration.addLast(3);");
            System.out.println("    - deque_demonstration = " + deque_demonstration);
            System.out.println("    - Peeking first element [deque_demonstration.peekFirst()]: " + deque_demonstration.peekFirst());
            System.out.println("    - Peeking last element [deque_demonstration.peekLast()]: " + deque_demonstration.peekLast());
            deque_demonstration.removeFirst();
            System.out.println("    - Removing first element with removeFirst()");
            System.out.println("    - deque_demonstration = " + deque_demonstration);
            deque_demonstration.removeLast();
            System.out.println("    - Removing last element with removeLast()");
            System.out.println("    - deque_demonstration = " + deque_demonstration);
        }
        if (this.generic instanceof Set){
            /*A Set is a collection that does NOT allow duplicate elements
              and does NOT guarantee order (depending on implementation).

              Main implementations:
              - HashSet → no order, fastest
              - LinkedHashSet → keeps insertion order
              - TreeSet → sorted order

              Sets are used when uniqueness matters:
              - Unique IDs
              - Tags
              - Removing duplicates from data
            */
            System.out.println("--- Collection [Set] ---");
            Set<Integer> set_demonstration = new HashSet<>();
            // You can swap implementations:
            // Set<Integer> set_demonstration = new LinkedHashSet<>();
            // Set<Integer> set_demonstration = new TreeSet<>();
            System.out.println("    - Creating Set: Set<Integer> set_demonstration = new HashSet<>();");
            set_demonstration.add(3);
            set_demonstration.add(1);
            set_demonstration.add(2);
            set_demonstration.add(2); // duplicate
            set_demonstration.add(3); // duplicate
            System.out.println("    - Adding values [set_demonstration.add(x);]: 3, 1, 2, 2, 3 (duplicates ignored)");
            System.out.println("    - set_demonstration = " + set_demonstration);
            System.out.println("    - Contains [set_demonstration.contains(2)]: " + set_demonstration.contains(2));
            set_demonstration.remove(1);
            System.out.println("    - Removing value 1 with set_demonstration.remove(1)");
            System.out.println("    - set_demonstration = " + set_demonstration);
            System.out.println("    - Iterating through Set with [for (Integer value : set_demonstration)]:");
            for (Integer value : set_demonstration) {
                System.out.println("        value = " + value);
            }
        }
        if (this.generic instanceof Map){
            /*A Map stores data in key-value pairs.

              Think of it like a dictionary:
              - Key = word
              - Value = definition

              Each key is unique, and maps to exactly one value.

              Used for:
              - Lookups
              - Caching
              - Configurations
            */
            System.out.println("--- Collection [Map] ---");
            Map<String, Integer> map_demonstration = new HashMap<>();
            System.out.println("    - Creating a Map: Map<String, Integer> map_demonstration = new HashMap<>();");
            map_demonstration.put("Apple", 1);
            map_demonstration.put("Banana", 2);
            map_demonstration.put("Orange", 3);
            System.out.println("    - Adding key-value pairs [map_demonstration.put(x,y)]: Apple=1, Banana=2, Orange=3");
            System.out.println("    - map_demonstration = " + map_demonstration);
            System.out.println("    - Accessing value for map_demonstration.get(\"Banana\"): " + map_demonstration.get("Banana"));
            map_demonstration.remove("Apple");
            System.out.println("    - Removing key 'Apple' with map_demonstration.remove(\"Apple\")");
            System.out.println("    - map_demonstration = " + map_demonstration);
        }
        if (this.generic instanceof ArrayList){
            /*An ArrayList is a dynamic array.

              Think of it like a resizable array:
              - Can grow and shrink automatically
              - Stores elements in order
              - Allows duplicates

              Used when:
              - You need fast access by index
              - You need ordered data
            */
            System.out.println("--- Collection [ArrayList] ---");
            ArrayList<String> list_demonstration = new ArrayList<>();
            System.out.println("    - Creating ArrayList: ArrayList<String> list_demonstration = new ArrayList<>();");
            list_demonstration.add("Apple");
            list_demonstration.add("Banana");
            list_demonstration.add("Orange");
            System.out.println("    - Adding items [list_demonstration.add(x)]: Apple, Banana, Orange");
            System.out.println("    - list_demonstration = " + list_demonstration);
            System.out.println("    - Accessing index 1 [list_demonstration.get(1)]: " + list_demonstration.get(1));
            list_demonstration.remove("Banana");
            System.out.println("    - Removing 'Banana' [list_demonstration.remove(\"Banana\")]");
            System.out.println("    - list_demonstration = " + list_demonstration);
        }
        if (this.generic instanceof int[]){
            /*An Array is a fixed-size container for storing elements of the same type.

              Think of it like a row of boxes:
              - Size is fixed when created
              - Cannot grow or shrink
              - Fast access using index

              Used when:
              - You know the size in advance
              - You need performance
            */
            System.out.println("--- Structure [Array] ---");
            int[] array_demonstration = new int[3];
            System.out.println("    - Creating array: int[] array_demonstration = new int[3];");
            array_demonstration[0] = 1;
            array_demonstration[1] = 2;
            array_demonstration[2] = 3;
            System.out.println("    - Assigning values [array_demonstration[x] = y;]: 1, 2, 3");
            System.out.println("    - array_demonstration[1] = " + array_demonstration[1]);
            System.out.print("    - Full array = ");
            for (int i : array_demonstration) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
