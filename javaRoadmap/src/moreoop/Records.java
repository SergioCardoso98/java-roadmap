package moreoop;

public record Records(String recordField1, int recordField2, float recordField3){ //Record is a special type of class used for immutable data carriers (auto-generates constructor, getters, equals, hashCode, toString)
    //One advantage is less boilerplate when we just want a simpler "object"
    public Records(String recordField1){ //Compact constructor overload for convenience when only one value is provided
        this(recordField1, 0, 0.00F); //Calls the main record constructor and assigns default values to missing fields
    }

    public String customMethod(){ //Custom method inside a record (records can still have methods)
        return "This is a custom method, and I know that this record recordField1 is " + recordField1; //Uses record field to build a message
    }
}