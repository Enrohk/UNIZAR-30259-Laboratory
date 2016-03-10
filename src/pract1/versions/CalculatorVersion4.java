package pract1.versions;

import pract1.common.CalculatorInterface;
import pract1.common.Operations;
import pract1.exceptions.CalculatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculatorVersion4 implements CalculatorInterface {


    private String SPLIT = ",\n";


    @Override
    public int sum(String numbers) throws CalculatorException {
        try {
            if (Operations.isEmptyOrNullAndThrowException(numbers)) {
                return 0;
            } else if (Operations.hasCustomDelimiter(numbers)) {
                SPLIT = Operations.changeSplit(numbers);
                //getNumbers
                numbers = numbers.split("\n")[1];
            }
            return sumNumbers(numbers);
        }
        catch (CalculatorException e){
            throw e;
        }
        catch (Exception e)
        {
            throw new CalculatorException();
        }

    }

    private int sumNumbers(String numbers) throws CalculatorException {
        int totalSum = 0;
        StringTokenizer st = new StringTokenizer(numbers, SPLIT);
        int newNumber;
        List<Integer> negativeNumbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            newNumber = Operations.getIntegerOrThrowException(st.nextToken());
            if (newNumber < 0){
                negativeNumbers.add(newNumber);
            }
            else {
                totalSum += Operations.sumIfPossible(newNumber);
            }
        }
        Operations.checkNegatives(negativeNumbers);
        return totalSum;
    }




}

