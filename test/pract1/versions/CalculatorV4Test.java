package pract1.versions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pract1.exceptions.CalculatorException;

import static org.junit.Assert.*;


public class CalculatorV4Test {

    private CalculatorV4 calculator = new CalculatorV4();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testWithOneBigNumberShouldIgnore () throws CalculatorException {
        assertTrue(0 == calculator.sum("1000"));
    }

    @Test(expected = CalculatorException.class)
    public void testNullParamShouldThrowException () throws CalculatorException {
        calculator.sum(null);
    }

    @Test
    public void testNonNumberStringParamShouldThrowException () throws CalculatorException {
        exception.expect(CalculatorException.class);
        calculator.sum("1,NonNumberString");
    }

    @Test
    public void testTwoParamsShouldReturnTheSum () throws CalculatorException {
        assertTrue(5 == calculator.sum("2,3"));
    }



    @Test
    public void testNegativeNumberShouldThrowExceptionWithMessage () throws CalculatorException {
        exception.expect(CalculatorException.class);
        exception.expectMessage("Números negativos no permitidos -1");
        assertTrue(-1 == calculator.sum("0,-1"));
    }

    @Test
    public void testNegativeNumbersShouldThrowExceptionWithMessage () throws CalculatorException {
        exception.expect(CalculatorException.class);
        exception.expectMessage("Números negativos no permitidos -1 -2 -3");
        assertTrue(-1 == calculator.sum("0,-1,-2,-3"));
    }

    @Test
    public void testSumEmptyStringShouldReturn0 () throws Exception {
        assertTrue(0 == calculator.sum(""));
    }

}