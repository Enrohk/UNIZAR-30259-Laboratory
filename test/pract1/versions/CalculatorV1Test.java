package pract1.versions;

import pract1.exceptions.CalculatorException;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class CalculatorV1Test {

    private CalculatorVersion1 calculator = new CalculatorVersion1();

    @Test (expected = CalculatorException.class)
    public void testShouldNoSupportLineJumps () throws CalculatorException
    {
        calculator.sum("1\n2");
    }

    @Test(expected = CalculatorException.class)
    public void testMoreThanTwoNumbersShouldThrowException () throws CalculatorException {
        calculator.sum("1,2,3");
    }

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
    public void testSumEmptyStringShouldReturn0 () throws CalculatorException {
        assertTrue(0 == calculator.sum(""));
    }

    @Test (expected = CalculatorException.class)
    public void testCorrectNumbersBUtIncorrectDelimiterShouldThrowException () throws CalculatorException
    {
        calculator.sum("1-2-3");
    }
}