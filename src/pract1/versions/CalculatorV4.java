package pract1.versions;


import pract1.common.CalculatorInterface;
import pract1.common.Operations;
import pract1.exceptions.CalculatorException;

public class CalculatorV4 implements CalculatorInterface{

    private static String SPLIT;
    private static int MAX_NUMBER = 1000;

    @Override
    public int sum(String numbers) throws CalculatorException {
        if (!Operations.isEmptyString(numbers) )
        {
            if(Operations.hasDelimiterDefinition(numbers))
            {
                String[] delimiterAndNumbers = numbers.split("\n");
                SPLIT = Operations.getSingleDelimiter(delimiterAndNumbers[0]);
                //numbers = numbers.split(SPLIT)[1];
            }
            else {
                SPLIT = ",";
            }
            numbers = Operations.deleteLineJumps(numbers);
            if(numbers.contains(SPLIT))
            {
                numbers = numbers.replaceAll("//","");
                String[] numbersArray = numbers.split(SPLIT);

                return Operations.getSumAndNegativeNumbersIgnoring(numbersArray,MAX_NUMBER).get(0);
            }
            else
            {
                int singleNumber = Operations.getIntegerNumber(numbers);
                if(singleNumber < 0 )
                {
                    throw new CalculatorException(Integer.toString(singleNumber));
                }
                else if(singleNumber >= MAX_NUMBER)
                {
                    return 0;
                }
                return singleNumber;
            }


        }
        return 0;
    }
}
