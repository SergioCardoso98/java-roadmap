package intermediate;

import java.util.Stack;

public class CollectionsWrapper<T> {
    private T generic;

    public CollectionsWrapper(T generic){
        this.generic = generic;
    }

    public void displayCollection(){
        if (this.generic instanceof Stack){
            System.out.println("Stack");
        }
    }
}
