package intermediate; // Declares the package where this class belongs

public class ExceptionHandling_Checked_NumberValidator extends Exception { // Creates a checked exception by extending Exception class
    public ExceptionHandling_Checked_NumberValidator() { super(); } // Default constructor calls parent Exception constructor
    public ExceptionHandling_Checked_NumberValidator(String errorMessage) { super(errorMessage); } // Constructor passes custom error message to Exception class
}