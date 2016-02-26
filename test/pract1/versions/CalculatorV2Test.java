package pract1.versions;

import org.junit.Test;
import pract1.exceptions.CalculatorException;

import static org.junit.Assert.*;


public class CalculatorV2Test
{

    private CalculatorV2 calculator = new CalculatorV2();

    @Test
    public void testMoreThanTwoNumbersShouldWork () throws CalculatorException {
       assertTrue( 6 == calculator.sum("1,2,3"));
    }

}