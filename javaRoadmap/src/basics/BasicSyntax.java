package basics;
// Java naming conventions:
//
// PascalCase  -> Class names
// Example: StudentManager, BankAccount
//
// camelCase   -> Variables and method names
// Example: firstName, calculateTotal()
//
// UPPER_SNAKE_CASE -> Constants (static final)
// Example: MAX_SIZE, PI_VALUE
//
// snake_case  -> Rarely used in Java
// Example: user_name
//
// kebab-case  -> Not valid for Java identifiers
// Example: user-name
public class BasicSyntax {
    //Simple DataTypes
    byte byteVar = 123; //Byte has a (signed) range from -128 to 127
    short shortVar = 123;//The short data type can store values from -32,768 to 32,767
    int intVar = 123; //standard integer - -2,147,483,648 to 2,147,483,647
    long longVar = 123L; //long integer - -9,223,372,036,854,775,808(-2^63) to 9,223,372,036,854,775,807(2^63 - 1
    float floatVar = 123.1212F;// 3.4e−038 to 3.4e+038 - 32 bits in size
    double doubleVar = 123.1212;//4.9e-324 to 1.7e+308 - 64 bits
    char charVar = 'a';//single character
    String stringVar = "Hello"; //text
    boolean boolVar = true; // true or false
    //vars initialization
    int initVar = 123;
    int init2Var;
    long digitSeparators = 1234_5678_9012_3456L;//any number of underscore characters (_) can appear anywhere between digits in a numerical literal. This feature enables you, for example. to separate groups of digits in numeric literals, which can improve the readability of your code.

    public int publicVar = 123; // accessible from everywhere
    protected int protectedVar = 123; //accessible only from this class and child classes
    private  int privateVar = 123; //only accessible in this class

    public void basicSyntax() {
        var varVar = "Hello"; //java determines the type at assignment, only allowed in inside methods, constructors, or blocks
        System.out.println("byteVar: " + byteVar);
        System.out.println("shortVar: " + shortVar);
        System.out.println("intVar: " + intVar);
        System.out.println("longVar: " + longVar);
        System.out.println("floatVar: " + floatVar);
        System.out.println("doubleVar: " + doubleVar);
        System.out.println("charVar: " + charVar);
        System.out.println("stringVar: " + stringVar);
        System.out.println("boolVar: " + boolVar);
        System.out.println("initVar: " + initVar);
        System.out.println("init2Var: " + init2Var);
        System.out.println("varVar: " + varVar + " //only allowed in inside methods, constructors, or blocks");
        System.out.println("digit separators: " + digitSeparators + " //typed in code like 1234_5678_9012_3456L");
        System.out.println("publicVar: " + publicVar + " // accessible from anywhere (same class, other classes, subclasses, different packages)");
        System.out.println("protectedVar: " + protectedVar + " //accessible in same class, subclasses, and same package");
        System.out.println("privateVar: " + privateVar + " //accessible only inside this class");
    }
}