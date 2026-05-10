package basics;

public class BasicSyntax {
    //Simple DataTypes
    byte byte_var = 123; //Byte has a (signed) range from -128 to 127
    short short_var = 123;//The short data type can store values from -32,768 to 32,767

    int int_var = 123; //standard integer - -2,147,483,648 to 2,147,483,647
    long long_var = 123L; //long integer - -9,223,372,036,854,775,808(-2^63) to 9,223,372,036,854,775,807(2^63 - 1

    float float_var = 123.1212F;// 3.4e−038 to 3.4e+038 - 32 bits in size
    double double_var = 123.1212;//4.9e-324 to 1.7e+308 - 64 bits

    char char_var = 'a';//single character
    String string_var = "Hello"; //text

    boolean bool_var = true; // true or false

    //vars initialization
    int init_var = 123;
    int init2_var;

    long digit_separators = 1234_5678_9012_3456L;//any number of underscore characters (_) can appear anywhere between digits in a numerical literal. This feature enables you, for example. to separate groups of digits in numeric literals, which can improve the readability of your code.

    public int public_var = 123; // accessible from everywhere
    protected int protected_var = 123; //accessible only from this class and child classes
    private  int private_var = 123; //only accessible in this class

    public void basicSyntax() {
        var var_var = "Hello"; //java determines the type at assignment, only allowed in inside methods, constructors, or blocks

        System.out.println("byte_var: " + byte_var);
        System.out.println("short_var: " + short_var);

        System.out.println("int_var: " + int_var);
        System.out.println("long_var: " + long_var);

        System.out.println("float_var: " + float_var);
        System.out.println("double_var: " + double_var);

        System.out.println("char_var: " + char_var);
        System.out.println("string_var: " + string_var);

        System.out.println("bool_var: " + bool_var);

        System.out.println("init_var: " + init_var);
        System.out.println("init2_var: " + init2_var);

        System.out.println("var_var: " + var_var + " //only allowed in inside methods, constructors, or blocks");

        System.out.println("digit separators: " + digit_separators + " //typed in code like 1234_5678_9012_3456L");

        System.out.println("public_var: " + public_var + " // accessible from anywhere (same class, other classes, subclasses, different packages)");

        System.out.println("protected_var: " + protected_var + " //accessible in same class, subclasses, and same package");

        System.out.println("private_var: " + private_var + " //accessible only inside this class");
    }
}
