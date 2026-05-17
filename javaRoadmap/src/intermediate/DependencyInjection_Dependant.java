package intermediate;

public class DependencyInjection_Dependant {
    // This is the injected dependency (NOT created here)
    private DependencyInjection_Injection injectedObject;
    // Dependency is RECEIVED through the constructor (this is constructor injection)
    public DependencyInjection_Dependant(DependencyInjection_Injection dii){
        this.injectedObject = dii;
    }
    // Uses the injected object instead of creating its own
    public void printDependant(){
        System.out.println("Dependant is using injected dependency:");
        System.out.println(" - attr1 = " + this.injectedObject.getInjection_attr1());
        System.out.println(" - attr2 = " + this.injectedObject.getInjection_attr2());
        System.out.println(" - attr3 = " + this.injectedObject.getInjection_attr3());
    }
}