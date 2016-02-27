package pract1.versions;

import org.junit.Test;
import pract1.exceptions.CalculatorException;

import static org.junit.Assert.*;

public class CalculatorV5Test
{

        private CalculatorV5 calculator = new CalculatorV5();

    @Test
    public void testOneParamShouldReturnThatNumber () throws CalculatorException {
            assertTrue(1000 == calculator.sum("1000"));
    }

    @Test(expected = CalculatorException.class)
    public void testNullParamShouldThrowException () throws CalculatorException {
        calculator.sum(null);
    }

    @Test(expected = CalculatorException.class)
    public void testNonNumberStringParamShouldThrowException () throws CalculatorException {
        calculator.sum("1,NonNumberString");
    }

    @Test
    public void testTwoParamsShouldReturnTheSum () throws CalculatorException {
        assertTrue(5 == calculator.sum("2,3"));
    }

    @Test
    public void testNegativeNumbersShouldWork () throws CalculatorException {
        assertTrue(-1 == calculator.sum("0,-1"));
    }

    @Test
    public void testSumEmptyStringShouldReturn0 () throws Exception {
        assertTrue(0 == calculator.sum(""));
    }

}