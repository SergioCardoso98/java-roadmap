package basics;

public class ConditionalAndLoops {
    public void conditionalAndLoops(){
        // Array to loop through
        int[] numbers = {2, 5, 8, 11, 14};

        // FOR LOOP
        for (int i = 0; i < numbers.length; i++) {

            int value = numbers[i];
            System.out.println("Normal For loop [for (int i = 0; i < numbers.length; i++)]");
            // CONDITIONAL (if / else)
            if (value % 2 == 0) {
                System.out.println(value + " is EVEN");
            } else {
                System.out.println(value + " is ODD");
            }
        }
        //"python for" -> "Enhanced for"
        for (int value : numbers) {

            System.out.println("Normal For loop [for (int value : numbers]");
            // CONDITIONAL (if / else)
            if (value % 2 == 0) {
                System.out.println(value + " is EVEN");
            } else {
                System.out.println(value + " is ODD");
            }
        }
    }
}
