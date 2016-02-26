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

    public static int getIntegerNumber (String numbers) throws CalculatorException
    {
        try
        {
            if (!(numbers.length() == 0))
            {
                return Integer.parseInt(numbers);
            }
            else return 0;
        }
        catch (Exception e)
        {
            throw new CalculatorException();
        }

    }

    public static int sumStringArray (String[] numbersArray) throws CalculatorException {

        int totalSum = 0;
        for (int i = 0; i < numbersArray.length; i++)
        {
            totalSum += getIntegerNumber(numbersArray[i]);
        }
        return totalSum;
    }

    public static String getSingleDelimiter(String delimiter) throws CalculatorException{

        return delimiter.substring(2);
    }

    public static boolean hasDelimiterDefinition(String numbers) throws CalculatorException{
        if(numbers.startsWith("//"))
        {
            return true;
        }
        else{
            return false;
        }
    }
}
