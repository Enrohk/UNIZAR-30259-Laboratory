package pract1.versions;


import pract1.common.CalculatorInterface;
import pract1.common.Operations;
import pract1.exceptions.CalculatorException;

public class CalculatorV1 implements CalculatorInterface
{
    private static String SPLIT = ",";

    @Override
    public int sum (String numbers) throws CalculatorException
    {
        if (!Operations.isEmptyString(numbers) )
        {

            if(numbers.contains(SPLIT))
            {
                String[] numbersArray = numbers.split(SPLIT);
                if(numbersArray.length>2)
                {
                    throw new CalculatorException();
                }
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
