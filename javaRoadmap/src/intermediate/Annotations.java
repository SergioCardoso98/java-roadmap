package intermediate;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.InputMismatchException;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//--------------------------------- Class using Custom + Built in Annotations ---------------------------------//

public class Annotations {

    // normal field → no validation annotation applied
    String stringAttr;

    // custom annotation → this field MUST NOT be null (checked via reflection)
    @CustomAnnotationNotnull
    String stringAttr2;

    // custom annotation → also must not be null
    @CustomAnnotationNotnull
    String stringAttr3;

    // constructor assigns values to fields and then validates object using reflection
    public Annotations(String value, String value2, String value3)
            throws InputMismatchException, IllegalAccessException {

        // assign first field
        stringAttr = value;

        // assign second field
        stringAttr2 = value2;

        // assign third field
        stringAttr3 = value3;

        // run validation logic that checks @CustomAnnotationNotnull fields
        new CustomAnnotationNotnullValidator().validate(this);
    }

    // marks method as deprecated (should not be used anymore)
    @Deprecated
    public void deprecatedSayHelloMethod(){
        System.out.println("deprecatedSayHelloMethod -> Hello");
    }

    // deprecated but warning suppressed at compile time
    @Deprecated
    @SuppressWarnings(value = "deprecation")
    public void suppressedDeprecatedSayHelloMethod(){
        System.out.println("suppressedDeprecatedSayHelloMethod -> Hello");
    }

    // normal method prints current object state
    public void sayHelloMethod(){
        System.out.println(
                "Annotations.sayHelloMethod -> Hello, my stringAttr value is: " + stringAttr + ", which is the only one that doesnt have the custom annotatio"
        );
    }
}

//--------------------------------- NOT USED IN MAIN, JUST TO DEMONSTRATE ---------------------------------//
class AnnotationsChild extends Annotations {

    // constructor calls parent constructor with all nulls
    AnnotationsChild() throws IllegalAccessException {
        super(null, null, null);
    }

    // overrides parent method and prints extra explanation
    @Override
    public void sayHelloMethod(){
        System.out.println(
                "AnnotationsChild.sayHelloMethod -> Hello, my stringAttr value is: "
                        + stringAttr
                        + ", which is the only one that doesnt have the custom annotation"
        );
    }
}

//--------------------------------- Custom Annotation Definition ---------------------------------//
/*
 * @CustomAnnotationNotnull is a CUSTOM annotation you created.
 *
 * It does NOT do anything by itself.
 *
 * It is just a MARKER (metadata) attached to fields.
 *
 * Purpose:
 * - You use it to mark fields that should NEVER be null
 * - A validator (reflection code) reads this annotation at runtime
 * - If a field is null and annotated → validation fails
 *
 * Why this is useful:
 * - You separate "rules" from "logic"
 * - You can apply rules declaratively instead of writing checks everywhere
 * - Frameworks (like Spring/Hibernate) use the same idea at large scale
 *
 * Without annotations:
 *   if (name == null) throw error in every class
 *
 * With annotations:
 *   @NotNull String name;
 *   → one validator handles ALL classes automatically
 */
@Documented
@Retention(RUNTIME)   // annotation exists at runtime (needed for reflection)
@Target(FIELD)        // can only be applied to fields
@interface CustomAnnotationNotnull {

    // optional message that can be used by validator
    String message() default "This field cannot be null";
}

class CustomAnnotationNotnullValidator {

    // checks any object for fields annotated with @CustomAnnotationNotnull
    public void validate(Object obj)
            throws InputMismatchException, IllegalAccessException {

        // get class metadata of the object
        Class<?> clazz = obj.getClass();

        // loop through all declared fields in the class
        for (Field field : clazz.getDeclaredFields()) {

            // allow access to private/protected fields
            field.setAccessible(true);

            // check:
            // 1. field has @CustomAnnotationNotnull
            // 2. field value is null
            if (field.isAnnotationPresent(CustomAnnotationNotnull.class)
                    && field.get(obj) == null) {

                // if invalid → throw exception with field name
                throw new InputMismatchException(
                        field.getName() + " cannot be null"
                );
            }
        }
    }
}