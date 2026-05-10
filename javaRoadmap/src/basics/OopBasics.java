/*
=========================================================
            JAVA ACCESS MODIFIERS CHEAT SHEET
=========================================================

There are 4 access levels in Java:

1. private
2. (default) package-private
3. protected
4. public

---------------------------------------------------------
1. PRIVATE
---------------------------------------------------------
- Only accessible inside the SAME class
- Not visible to other classes or subclasses

USE FOR:
- internal logic
- hiding implementation details

Example:
private int value;

---------------------------------------------------------
2. DEFAULT (no keyword)
---------------------------------------------------------
- Accessible ONLY inside the SAME package
- NOT visible outside package (even subclasses)

USE FOR:
- package-level grouping
- internal project modules

Example:
int value;   // no modifier

---------------------------------------------------------
3. PROTECTED
---------------------------------------------------------
- Accessible in:
    * same class
    * same package
    * subclasses (even in different packages)

USE FOR:
- inheritance (child classes need access)
- shared base-class logic

Example:
protected int value;

---------------------------------------------------------
4. PUBLIC
---------------------------------------------------------
- Accessible from ANYWHERE
- No restrictions

USE FOR:
- API methods
- entry points (like main)
- classes meant to be used externally

Example:
public int value;

---------------------------------------------------------
SUMMARY RULE (VERY IMPORTANT)

private    → only inside class
default    → package only
protected  → package + child classes
public     → everywhere

=========================================================
*/
package basics;

public class OopBasics {
    int attr1;
    String attr2;
    float attr3;

    public OopBasics(){
        this.attr1 = 0;
        this.attr2 = "0";
        this.attr3 = 0.00F;
    }

    public OopBasics(int param1, String param2,float param3){
        this.attr1 = param1;
        this.attr2 = param2;
        this.attr3 = param3;
    }

    public static void static_method(){
        System.out.println("This is a static method");
    }

    public void print_object(){
        System.out.println(this);
    }

    public final class NestedClass{//since this class is marked as final it can’t be extended
        final int someAttr = 1;//int someAttr can't be changed since it was marked as final, so it must be used as is
        public NestedClass(){}
        public final void nestedClassMethod(final int int1){
            //since this method is marked as final it can’t be extended
            //int int1 can't be changed since it was marked as final, so it must be used as is
        }
    }
}
