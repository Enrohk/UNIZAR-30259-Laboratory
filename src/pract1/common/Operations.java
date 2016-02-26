package pract1.common;


import pract1.exceptions.CalculatorException;

public class Operations {

    /**
     * @param string
     * @return if string param is empy
     * @throws CalculatorException when string is not a number
     */
    public static boolean isEmptyString (String string) throws CalculatorException
    {
        try
        {
            return string.length() == 0;
        }
        catch (NullPointerException e)
        {
            throw new CalculatorException();
        }

    }

    public static String deleteLineJumps (String string)
    {
        return string.replace("\n","");
    }

    public static int getIntegerNumber (String num) throws CalculatorException
    {
        try
        {
            if (!(num.length() == 0))
            {
                return Integer.parseInt(num);
            }
            else return 0;
        }
        catch (Exception e)
        {
            throw new CalculatorException();
        }

    }
}
