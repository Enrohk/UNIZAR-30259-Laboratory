package pract1.versions;

import pract1.common.CalculatorInterface;
import pract1.common.Operations;
import pract1.exceptions.CalculatorException;

public class CalculatorV3 implements CalculatorInterface
{
    private static String SPLIT;

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
                String[] numbersArray = numbers.split("//")[1].split(SPLIT);

                return Operations.sumStringArray(numbersArray);
            }
            else
            {
                return Operations.getIntegerNumber(numbers);
            }


        }
        return 0;
    }
}
