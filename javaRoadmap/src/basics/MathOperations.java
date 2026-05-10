package basics;

public class MathOperations {
    public void mathOperations(){
        // BASIC OPERATORS
        int a = 10;
        int b = 3;

        System.out.println("Addition: " + (a + b));        // 13
        System.out.println("Subtraction: " + (a - b));     // 7
        System.out.println("Multiplication: " + (a * b));  // 30
        System.out.println("Division: " + (a / b));        // 3
        System.out.println("Remainder: " + (a % b));       // 1

        // MATH CLASS (common examples)
        System.out.println("Max: " + Math.max(a, b));      // 10
        System.out.println("Min: " + Math.min(a, b));      // 3

        System.out.println("Absolute: " + Math.abs(-5));   // 5
        System.out.println("Square root: " + Math.sqrt(16)); // 4.0

        System.out.println("Round: " + Math.round(4.6));   // 5
        System.out.println("Ceil: " + Math.ceil(4.2));     // 5.0
        System.out.println("Floor: " + Math.floor(4.8));   // 4.0

        System.out.println("Power: " + Math.pow(2, 3));    // 8.0
    }
}
