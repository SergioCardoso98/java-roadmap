package moreoop;

public class Enums {
    public enum EnumsType {// An enum is a special type that contains a fixed set of constants
        ENUM1("enum1 description"),// Enum constants (objects/instances of the enum)
        ENUM2(("enum2 description")),// Enum constants (objects/instances of the enum)
        ENUM3(("enum3 description"));// Enum constants (objects/instances of the enum)
        final String enumDescription;// Field that stores the description for each enum constant
        EnumsType(String enumDescription){ // Constructor for the enum + Runs once for each enum constant above
            this.enumDescription = enumDescription; // Assigns the parameter value to the field
        }
    }

    public String enumObjectName;// Stores the name of this enum-based object
    public EnumsType enumType;// Stores the type of enum assigned to this object

    public Enums(String p_enumObjectName, EnumsType p_enumType){// Constructor for creating object
        enumObjectName = p_enumObjectName;// Assigns name to field
        enumType = p_enumType;// Assigns enum type to field
    }
}
