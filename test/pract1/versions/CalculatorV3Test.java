package pract1.versions;

import org.junit.Test;
import pract1.exceptions.CalculatorException;

import static org.junit.Assert.*;

public class CalculatorV3Test {

    private CalculatorV3 calculator = new CalculatorV3();

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

    @Test
    public void testChangeDelimiterShouldWorkWithOneNumber () throws CalculatorException {
        assertTrue(1 == calculator.sum("//;\n1"));
    }

    @Test
    public void testChangeDelimiterShouldWorkWithMultipleNumber () throws CalculatorException {
        assertTrue(10 == calculator.sum("//;\n1;2;3;4"));
    }

    @Test (expected = CalculatorException.class)
    public void testChangeDelimiterBadDefinedShouldThrowException () throws CalculatorException{
        calculator.sum("/;2");
    }

    @Test (expected = CalculatorException.class)
    public void testChangeDelimiterBadUsageShouldThrowException () throws CalculatorException{
        calculator.sum("//;\n2,1");
    }

    @Test (expected = CalculatorException.class)
    public void testChangeDelimiterBadDefinedNoLineJUmpShouldThrowException () throws CalculatorException{
        calculator.sum("//;2,1");
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

}