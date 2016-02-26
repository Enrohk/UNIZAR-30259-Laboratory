package pract1.common;


import pract1.exceptions.CalculatorException;

import java.util.ArrayList;
import java.util.List;

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
        for (String number: numbersArray)
        {
            totalSum += getIntegerNumber(number);
        }
        return totalSum;
    }

    /**
     *
     * @param numberArray
     * @param numToIgnore number above this will be ignored
     * @return list which first item is the sum ignoring numToIgnore and
     *          not counting negative integers
     * @throws CalculatorException
     */
    public static List<Integer> getSumAndNegativeNumbersIgnoring (String[] numberArray,
                                                                  int numToIgnore)
        throws CalculatorException
    {
        List<Integer> returnList = new ArrayList<Integer>();
        int current;

        for (String number: numberArray)
        {
            current = getIntegerNumber(number);
            if(current <= numToIgnore && current > 0)
            {
                returnList.set(0, returnList.get(0)+current);
            }
            if(current<0){
                returnList.add(current);
            }

        }
        if(returnList.size()>1){
            throw new CalculatorException(getNumbersMessage(returnList));
        }

        return returnList;
    }

    private static String getNumbersMessage(List<Integer> returnList)
    {
        String message = "Números negativos no permitidos ";
        for(int i = 1; i<returnList.size(); i++){
            message += returnList.get(i) + " ";
        }
        return message;

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
