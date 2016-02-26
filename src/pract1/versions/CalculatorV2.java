package pract1.versions;


import pract1.common.CalculatorInterface;
import pract1.common.Operations;
import pract1.exceptions.CalculatorException;

public class CalculatorV2 implements CalculatorInterface {

    private static String SPLIT = ",";

    public int sum (String numbers) throws CalculatorException
    {
        if (!Operations.isEmptyString(numbers) )
        {
            if(numbers.contains(SPLIT))
            {
                String[] numbersArray = numbers.split(SPLIT);
                int totalSum = 0;
                for (int i = 0; i < numbersArray.length; i++)
                {
                    totalSum += Operations.getIntegerNumber(numbersArray[i]);
                }
                return totalSum;
            }
            else
            {
                return Operations.getIntegerNumber(numbers);
            }
        }
        return 0;
    }

}
