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

    @Test
    public void testLineJumpInStringInputShouldWork () throws CalculatorException {
        assertTrue(1 == calculator.sum("0\n,1"));
    }

    @Test
    public void testLineJumpInStringInputWithCommaShouldWork () throws CalculatorException {
        assertTrue(1 == calculator.sum("0,\n,1"));
    }

}