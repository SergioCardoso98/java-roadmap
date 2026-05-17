package intermediate;

public class DependencyInjection_Injection {

    // These are the data fields of the dependency
    private String injection_attr1;
    private String injection_attr2;
    private String injection_attr3;

    // Constructor used to initialize the dependency object
    public DependencyInjection_Injection(String injection_attr1, String injection_attr2, String injection_attr3){
        this.injection_attr1 = injection_attr1;
        this.injection_attr2 = injection_attr2;
        this.injection_attr3 = injection_attr3;
    }

    // Getter methods allow other classes (like Dependant) to access private data safely
    public String getInjection_attr1() {
        return injection_attr1;
    }

    public String getInjection_attr2() {
        return injection_attr2;
    }

    public String getInjection_attr3() {
        return injection_attr3;
    }

    // Prints the internal state of this dependency object
    public void printInjection(){
        System.out.println("Injection object state:");
        System.out.println(" - injection_attr1 = " + this.injection_attr1);
        System.out.println(" - injection_attr2 = " + this.injection_attr2);
        System.out.println(" - injection_attr3 = " + this.injection_attr3);
    }
}