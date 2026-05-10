package moreoop;

public class MethodChaining {
    public String attr1; // First attribute stored in the object
    public String attr2; // Second attribute stored in the object

    public MethodChaining(String p_attr1, String p_attr2) { // Constructor to initialize both attributes
        attr1 = p_attr1; // Assigns first parameter to attr1
        attr2 = p_attr2; // Assigns second parameter to attr2
    }

    public MethodChaining printBothAttr() { // Method that prints both attributes and supports method chaining
        System.out.println(attr1 + " " + attr2); // Prints attr1 and attr2 together
        return this; // Returns current object to allow chaining
    }
    public String addSmile() { // Method that returns a smile emoji string
        return "😘"; // Returns emoji as a string
    }
}