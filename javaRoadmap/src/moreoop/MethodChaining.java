package moreoop;

public class MethodChaining {
    public String attr1;
    public String attr2;
    public MethodChaining(String p_attr1, String p_attr2){
        attr1 = p_attr1;
        attr2 = p_attr2;
    }
    public MethodChaining printBothAttr(){
        System.out.println(attr1 + " " + attr2);
        return this;
    }
    public String addSmile(){
        return "😘";
    }
}
