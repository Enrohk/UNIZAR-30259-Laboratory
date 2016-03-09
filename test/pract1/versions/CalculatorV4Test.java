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
    public void testShouldIgnoreBigNumbers () throws CalculatorException {
        assertTrue(5 == calculator.sum("0,1000,1,10001,4,24242"));
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


    @Test (expected = CalculatorException.class)
    public void testCorrectNumbersBUtIncorrectDelimiterShouldThrowException () throws CalculatorException
    {
        calculator.sum("1-2-3");
    }

    @Test
    public void testShouldWorkFineWithMultipleLineJumps () throws CalculatorException
    {
        assertTrue(6 == calculator.sum("1\n2,2\n\n\n1"));
    }

   /* @Test
    public void testShouldWorkFineWithNewDelimiterAsLineJump () throws CalculatorException
    {
        assertTrue(9 == calculator.sum("//\n\n2\n4\n3"));
    }*/

}