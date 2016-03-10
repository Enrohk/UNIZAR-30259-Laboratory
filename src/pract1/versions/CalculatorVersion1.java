package pract1.versions;


import pract1.common.CalculatorInterface;
import pract1.exceptions.CalculatorException;

import java.util.StringTokenizer;

public class CalculatorVersion1 implements CalculatorInterface{


    private String SPLIT = ",";


    @Override
    public int sum(String numbers) throws CalculatorException {

        if(isEmptyOrNullAndThrowException(numbers))
        {
            return 0;
        }

        else
        {
            return sumNumbers(numbers);
        }
    }

    private boolean isEmptyOrNullAndThrowException (String s) throws CalculatorException {
        try {
            return s.length()==0;
        }
       catch (Exception e){
           throw new CalculatorException();
       }
    }

    private int sumNumbers (String numbers) throws CalculatorException
    {
        int totalSum = 0;
        StringTokenizer st = new StringTokenizer(numbers,SPLIT);
        int totalNumbers = 0;
        while(st.hasMoreTokens())
        {
            totalSum += getIntegerOrThrowException(st.nextToken());
            totalNumbers ++;
        }
        if(totalNumbers >2 )
        {
            throw new CalculatorException();
        }
        return totalSum;
    }

    private int getIntegerOrThrowException (String number) throws CalculatorException
    {
        try{
            return Integer.parseInt(number);
        }
        catch (Exception e)
        {
            throw new CalculatorException();
        }
    }
}
