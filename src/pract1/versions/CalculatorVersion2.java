package pract1.versions;


import pract1.common.CalculatorInterface;
import pract1.common.Operations;
import pract1.exceptions.CalculatorException;
import java.util.StringTokenizer;

public class CalculatorVersion2 implements CalculatorInterface{


    private String SPLIT = ",\n";


    @Override
    public int sum(String numbers) throws CalculatorException {

        if(Operations.isEmptyOrNullAndThrowException(numbers))
        {
            return 0;
        }
        else
        {
            return sumNumbers(numbers);
        }
    }



    private int sumNumbers (String numbers) throws CalculatorException
    {
        int totalSum = 0;
        StringTokenizer st = new StringTokenizer(numbers,SPLIT);
        while(st.hasMoreTokens())
        {
            totalSum += Operations.getIntegerOrThrowException(st.nextToken());
        }
        return totalSum;
    }

}
