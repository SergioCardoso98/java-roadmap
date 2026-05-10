package moreoop;

public class InitializerBlock { //Class demonstrating static block, instance block, and constructor execution order

    static { //Static initialization block runs once when class is first loaded into memory
        System.out.println("Static initialization block just ran"); //Executes only once for the entire class
    }

    { //Instance initialization block runs every time a new object is created, before the constructor
        System.out.println("Instance initialization block just ran"); //Runs for each new object
    }

    public InitializerBlock(){ //Constructor runs after instance initialization block
        System.out.println("Constructor just ran"); //Final step in object creation process
    }
}