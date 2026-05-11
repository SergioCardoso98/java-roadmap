import basics.*;
import moreoop.*;
public class Main {
    public static void main(String[] args) {
        //runBasics();
        //runMoreoop(6);
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
}