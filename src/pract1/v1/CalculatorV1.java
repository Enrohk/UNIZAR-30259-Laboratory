package pract1.v1;


import exceptions.pract1.CalculatorException;

public class CalculatorV1
{
    private static String SPLIT = ",";

    public static int sum (String numbers) throws CalculatorException
    {
        if (!isEmptyString(numbers) )
        {
            if(numbers.contains(SPLIT))
            {
                String[] numbersArray = numbers.split(SPLIT);
                int totalSum = 0;
                for (int i = 0; i < numbersArray.length; i++)
                {
                   totalSum += getIntegerNumber(numbersArray[i]);
                }
                return totalSum;
            }
            else
            {
                return getIntegerNumber(numbers);
            }
        }
        return 0;

    }

    /**
     * @param string
     * @return if string param is empy
     * @throws CalculatorException when string is not a number
     */
    private static boolean isEmptyString (String string) throws CalculatorException
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

    private static int getIntegerNumber (String num) throws CalculatorException
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
