package pract1.versions;

import exceptions.pract1.CalculatorException;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorV1Test {

    @Test
    public void testSumEmptyStringShouldReturn0 () throws Exception {
        assertTrue(0 == CalculatorV1.sum(""));
    }

    @Test(expected = CalculatorException.class)
    public void testNullParamShouldThrowException () throws CalculatorException {
       CalculatorV1.sum(null);
    }

    @Test(expected = CalculatorException.class)
    public void testNonNumberStringParamShouldThrowException () throws CalculatorException {
        CalculatorV1.sum("1,NonNumberString");
    }

    @Test
    public void testOneParamShouldReturnThatNumber () throws CalculatorException {
        assertTrue(1000 == CalculatorV1.sum("1000"));
    }

    @Test
    public void testTwoParamsShouldReturnTheSum () throws CalculatorException {
        assertTrue(5 == CalculatorV1.sum("2,3"));
    }

    @Test
    public void testNegativeNumbersShouldWork () throws CalculatorException {
        assertTrue(-1 == CalculatorV1.sum("0,-1"));
    }

    @Test
    public void testMoreThanTwoNumbersShouldThrowException () throws CalculatorException {
        CalculatorV1.sum("1,2,3");
    }
}