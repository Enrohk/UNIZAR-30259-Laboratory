package pract1.versions;

import pract1.common.CalculatorInterface;
import pract1.exceptions.CalculatorException;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CalculatorVersion4 implements CalculatorInterface {


    private String SPLIT = ",\n";
    private int NUMBER_TO_IGNORE = 1000;


    @Override
    public int sum(String numbers) throws CalculatorException {
        try {
            if (isEmptyOrNullAndThrowException(numbers)) {
                return 0;
            } else if (hasCustomDelimiter(numbers)) {
                changeSplit(numbers);
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

    private void changeSplit(String numbers) {

        SPLIT = numbers.split("\n")[0].substring(2);
    }

    private boolean hasCustomDelimiter(String numbers) {
        return numbers.startsWith("//");
    }

    private boolean isEmptyOrNullAndThrowException(String s) throws CalculatorException {
        try {
            return s.length() == 0;
        } catch (Exception e) {
            throw new CalculatorException();
        }
    }

    private int sumNumbers(String numbers) throws CalculatorException {
        int totalSum = 0;
        StringTokenizer st = new StringTokenizer(numbers, SPLIT);
        int newNumber;
        List<Integer> negativeNumbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            newNumber = getIntegerOrThrowException(st.nextToken());
            if (newNumber < 0){
                negativeNumbers.add(newNumber);
            }
            else {
                totalSum += sumIfPossible(newNumber);
            }
        }
        checkNegatives(negativeNumbers);
        return totalSum;
    }

    private int sumIfPossible(int newNumber) {
        if(newNumber < NUMBER_TO_IGNORE){
            return newNumber;
        }
        return 0;
    }

    private void checkNegatives(List<Integer> negativeNumbers) throws CalculatorException {
        if(negativeNumbers.size()>0){
            String msg = "";
            for(Integer negative : negativeNumbers){
                msg +=" " + negative;
            }
            throw new CalculatorException(msg);
        }
    }

    private int getIntegerOrThrowException(String number) throws CalculatorException {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new CalculatorException();
        }
    }
}

