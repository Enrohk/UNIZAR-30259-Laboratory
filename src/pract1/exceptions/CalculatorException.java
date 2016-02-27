package pract1.exceptions;


public class CalculatorException extends Exception
{

    private static String MESSAGE = "Números negativos no permitidos ";

    public CalculatorException()
    {

    }

    public CalculatorException(String message) {
        super(MESSAGE + message);
    }
}
