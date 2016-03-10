package pract1.common;

import pract1.exceptions.CalculatorException;

import java.util.List;

public class Operations {

    private static int NUMBER_TO_IGNORE = 1000;

    public static boolean isEmptyOrNullAndThrowException (String s) throws CalculatorException {
        try {
            return s.length()==0;
        }
        catch (Exception e){
            throw new CalculatorException();
        }
    }

    public static String changeSplit(String numbers) {

        return numbers.split("\n")[0].substring(2);
    }

    public static int getIntegerOrThrowException (String number) throws CalculatorException
    {
        try{
            return Integer.parseInt(number);
        }
        catch (Exception e)
        {
            throw new CalculatorException();
        }
    }

    public static boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    public static void checkNegatives(List<Integer> negativeNumbers) throws CalculatorException {
        if(negativeNumbers.size()>0){
            String msg = "";
            for(Integer negative : negativeNumbers){
                msg +=" " + negative;
            }
            throw new CalculatorException(msg);
        }
    }

    public static int sumIfPossible(int newNumber) {
        if (newNumber < NUMBER_TO_IGNORE) {
            return newNumber;
        }
        return 0;
    }
}
