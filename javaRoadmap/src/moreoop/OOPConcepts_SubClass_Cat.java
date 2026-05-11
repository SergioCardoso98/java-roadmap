package moreoop; // package location

// Cat inherits from Animal abstract class (gets name, age, alive, getters/setters)
public class OOPConcepts_SubClass_Cat extends OOPConcepts_BaseClass_Animal {

    // constructor passes values to parent class
    public OOPConcepts_SubClass_Cat(String p_name, int p_age, boolean p_alive) {
        super(p_name, p_age, p_alive); // initialize parent fields
    }

    // overriding abstract method from Animal
    // OVERRIDING:
    // same method name + same parameters as parent abstract method
    @Override

    // DYNAMIC BINDING:
    // chosen at runtime depending on actual object type
    public String talk() {
        return "Meow"; // Cat-specific implementation
    }

    // STATIC BINDING EXAMPLE:
    // static methods are resolved at compile time
    public static void info() {
        System.out.println("Cats are animals");
    }
}