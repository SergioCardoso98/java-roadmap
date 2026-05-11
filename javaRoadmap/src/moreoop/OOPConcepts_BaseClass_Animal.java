package moreoop; // package declaration
// abstract class = cannot be instantiated directly
// implements interface = must provide alive() method OR be abstract
public abstract class OOPConcepts_BaseClass_Animal implements OOPConcepts_Animal_Interface {

    private String name; // encapsulated field (hidden from outside)
    private int age;     // encapsulated field
    public boolean alive; // state of the animal (Forced to have by interface InAbsEncAnimal_Interface)

    // constructor initializes object state
    public OOPConcepts_BaseClass_Animal(String p_name, int p_age, boolean p_alive) {
        setName(p_name); // use setter (allows validation if needed)
        setAge(p_age);   // use setter (enforces MAX_AGE rule)
        this.alive = p_alive; // assign alive state directly
    }

    // getter for name
    public String getName() {return this.name;}

    // setter for name
    public void setName(String value) {this.name = value;}

    // getter for age
    public int getAge() {return this.age;}

    // setter with validation using interface constant
    public void setAge(int value) {
        if (value > MAX_AGE) { // use interface constant
            this.age = 50; // cap age if too high
        } else {
            this.age = value; // normal assignment
        }
    }

    // abstract method → must be implemented by subclasses
    // DYNAMIC BINDING:
    // Java decides at runtime which subclass version of talk() to execute
    public abstract String talk();

    // implementation of interface method
    // DYNAMIC BINDING possible if subclass overrides alive()
    public boolean alive() {
        return this.alive; // returns current alive state
    }

    // OVERLOADING EXAMPLE:
    // same method name, different parameters
    public void setAge(String value) {
        this.age = Integer.parseInt(value);
    }
}