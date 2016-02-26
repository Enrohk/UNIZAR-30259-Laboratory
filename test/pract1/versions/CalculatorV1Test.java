package pract1.versions;

import pract1.exceptions.CalculatorException;
import org.junit.Test;


public class CalculatorV1Test {

    private CalculatorV1 calculator = new CalculatorV1();

    @Test(expected = CalculatorException.class)
    public void testMoreThanTwoNumbersShouldThrowException () throws CalculatorException {
        calculator.sum("1,2,3");
    }
}