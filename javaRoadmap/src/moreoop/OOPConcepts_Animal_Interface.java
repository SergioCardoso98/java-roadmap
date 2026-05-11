package moreoop; // interface belongs to same package
public interface OOPConcepts_Animal_Interface {
    int MAX_AGE = 50; // constant shared by all animals (public static final by default)
    boolean alive(); // contract: all animals MUST implement this method
}