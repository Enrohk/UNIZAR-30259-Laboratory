package test.pract1.v1;

import exceptions.pract1.CalculatorException;
import org.junit.Test;
import pract1.v1.CalculatorV1;

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
}