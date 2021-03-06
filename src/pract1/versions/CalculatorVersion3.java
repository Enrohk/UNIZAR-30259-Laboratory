package pract1.versions;

import pract1.common.CalculatorInterface;
import pract1.common.Operations;
import pract1.exceptions.CalculatorException;
import java.util.StringTokenizer;


public class CalculatorVersion3 implements CalculatorInterface {


    private String SPLIT = ",\n";


    @Override
    public int sum(String numbers) throws CalculatorException {
        try {
            if (Operations.isEmptyOrNullAndThrowException(numbers)) {
                return 0;
            } else if (Operations.hasCustomDelimiter(numbers)) {
                changeSplit(numbers);
                //getNumbers
                numbers = numbers.split("\n")[1];
            }
            return sumNumbers(numbers);
        }
        catch (Exception e)
        {
            throw new CalculatorException();
        }

    }

    private void changeSplit(String numbers) {

        SPLIT = numbers.split("\n")[0].substring(2);
    }




    private int sumNumbers(String numbers) throws CalculatorException {
        int totalSum = 0;
        StringTokenizer st = new StringTokenizer(numbers, SPLIT);
        while (st.hasMoreTokens()) {
            totalSum += Operations.getIntegerOrThrowException(st.nextToken());
        }
        return totalSum;
    }

}
