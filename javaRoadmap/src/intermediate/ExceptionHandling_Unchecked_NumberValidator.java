package intermediate; // Declares the package where this class belongs

public class ExceptionHandling_Unchecked_NumberValidator extends RuntimeException { // Creates an unchecked exception by extending RuntimeException class
    public ExceptionHandling_Unchecked_NumberValidator() { super(); } // Default constructor calls parent RuntimeException constructor
    public ExceptionHandling_Unchecked_NumberValidator(String errorMessage) { super(errorMessage); } // Constructor passes custom error message to RuntimeException class
}