import basics.*;//imports from package basics that has the various classes
import moreoop.*;
public class Main {
    public static void main(String[] args) {
        //runBasics();
        runMoreoop(3);
    }
    public static void runBasics(){
        BasicSyntax bs = new BasicSyntax();
        TypeCasting tc = new TypeCasting();
        MathOperations mo = new MathOperations();
        Arrays arr = new Arrays();
        ConditionalAndLoops cal = new ConditionalAndLoops();

        OopBasics oopb = new OopBasics();
        OopBasics oopb2 = new OopBasics(1, "custom string", 1.00F);
        oopb.print_object();
        oopb2.print_object();
        OopBasics.static_method();
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
            MethodChaining mco = new MethodChaining("I have a", "surprise for you, here: ");
            System.out.println("Method chaining is when a method returns the same object (this), so you can call another method immediately on it.");
            System.out.println("System.out.println(mco.printBothAttr().addSmile()) = ");
            System.out.println(mco.printBothAttr().addSmile());
            System.out.println("Without method chaining would be");
            System.out.println("System.out.println(mco.printBothAttr() + mco.addSmile())");
            System.out.println(mco.printBothAttr() + mco.addSmile());
        }
        if (module == 3){}
    }
}