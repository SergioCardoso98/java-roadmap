package intermediate;
import java.lang.annotation.*;
import java.lang.reflect.Field;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

//--------------------------------- Class using Custom + Built in Annotations ---------------------------------//

public class Annotations {
    @CustomAnnotationNotnull String stringAttr;
    public Annotations(String value){
        stringAttr = value;
    }

    @Deprecated
    public void deprecatedSayHelloMethod(){
        System.out.println("deprecatedSayHelloMethod -> Hello");
    }

    @Deprecated
    @SuppressWarnings("Deprecated")
    public void suppressedDeprecatedSayHelloMethod(){
        System.out.println("suppressedDeprecatedSayHelloMethod -> Hello");
    }

    public void sayHelloMethod(){
        System.out.println("Annotations.sayHelloMethod -> Hello, my stringAttr value is: " + stringAttr);
    }
}
//--------------------------------- NOT USED IN MAIN, JUST TO DEMONSTRATE ---------------------------------//
class AnnotationsChild extends Annotations {
    AnnotationsChild(String value) {
        super(value);
    }

    @Override
    public void sayHelloMethod(){
        System.out.println("AnnotationsChild.sayHelloMethod -> Hello, my stringAttr value is: " + stringAttr);
    }
}

//--------------------------------- Interface to create Custom Annotation ---------------------------------//
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@interface CustomAnnotationNotnull {
    String message() default "This field cannot be null";
}

class CustomAnnotationNotnullValidator{
    public boolean validate(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()){
            field.setAccessible(true);
            try {
                if (field.isAnnotationPresent(CustomAnnotationNotnull.class)) {
                    if (field.get(obj) == null) {
                        return false;
                    }
                }
            }catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}