package moreoop;

public class ObjectLifeCycle { //Class demonstrating basic object lifecycle concepts

    public String attr; //Stores a value inside the object

    public ObjectLifeCycle(String p_attr){ //Constructor called when object is created
        this.attr = p_attr; //Initializes attribute with provided value
    }

    public String getAttr(){ //Getter method to access attribute value
        return this.attr; //Returns the stored attribute
    }
}