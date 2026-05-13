package intermediate;

public class ExceptionHandling_Unchecked_NumberValidator extends RuntimeException {
    public ExceptionHandling_Unchecked_NumberValidator(){super();};
    public ExceptionHandling_Unchecked_NumberValidator(String errorMessage){super(errorMessage);}
}
