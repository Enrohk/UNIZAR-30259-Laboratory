package pract1.common;


import pract1.exceptions.CalculatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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

    public static String deleteLineJumps (String string, String split)
    {
        return string.replaceAll("\n",split);
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

    public static int sumStringTokenizer (StringTokenizer st) throws CalculatorException {
        int totalSum = 0;
        while(st.hasMoreTokens())
        {
            totalSum += getIntegerNumber(st.nextToken());
        }
        return totalSum;
    }

    /**
     *
     * @param numToIgnore number above this will be ignored
     * @return list which first item is the sum ignoring numToIgnore and
     *          not counting negative integers
     * @throws CalculatorException
     */
    public static List<Integer> getSumAndNegativeNumbersIgnoring (StringTokenizer st,
                                                                  int numToIgnore)
            throws CalculatorException
    {
        List<Integer> returnList = new ArrayList<Integer>();
        returnList.add(0);
        int current;

        while (st.hasMoreTokens())
        {
            current = getIntegerNumber(st.nextToken());
            if(current < numToIgnore && current > 0)
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
        returnList.add(0);
        int current;

        for (String number: numberArray)
        {
            current = getIntegerNumber(number);
            if(current < numToIgnore && current > 0)
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
        String message = "";
        for(int i = 1; i<returnList.size(); i++){
            message += returnList.get(i) + " ";
        }
        return message;

    }



    public static String getSingleDelimiter (String delimiter) throws CalculatorException{

        if(delimiter.substring(2).length()==1)
        {
            return delimiter.substring(2);
        }
        //\n \r \t delimiters.
        else if(delimiter.substring(2).length()==2 && delimiter.substring(2).startsWith("\\"))
        {
            return delimiter.substring(2);
        }
        else
            throw new CalculatorException();

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

    public static String getMultipleDelimiter (String delimiter) throws CalculatorException {

        if(delimiter.substring(2).length()==1)
        {
            return getSingleDelimiter(delimiter);
        }
        //\n \r \t delimiters.
        else if(delimiter.substring(2).length()==2 && delimiter.substring(2).startsWith("\\"))
        {
            return getSingleDelimiter(delimiter);
        }
        else
            return getRegExp(delimiter);

    }

    public static String getRegExp(String splitExpReg) {


        //Delete last line jump if exists
        if(splitExpReg.endsWith("\n"))
        {
            splitExpReg = splitExpReg .substring(0,splitExpReg.length()-1);
        }
        //delte first 2 //
        if(splitExpReg.startsWith("//"))
        {
            splitExpReg = splitExpReg.substring(2);
        }
        //convert split to regExp
        splitExpReg = "[" + splitExpReg + "]+";
        return splitExpReg;

    }

}
