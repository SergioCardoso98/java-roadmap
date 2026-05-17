package intermediate;

public class OptionalDisplayObject {
    public String attrString;
    public int attrInt;
    public OptionalDisplayObject(String attrString, int attrInt){
        this.attrString = attrString;
        this.attrInt = attrInt;
    }

    public void printDisplayObj(){
        System.out.println("This object is composed from -> attrString="+this.attrString+" + attrInt=" + this.attrInt );
    }
}
