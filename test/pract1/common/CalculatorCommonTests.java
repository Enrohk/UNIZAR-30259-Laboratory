package pract1.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pract1.exceptions.CalculatorException;
import pract1.versions.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CalculatorCommonTests {

    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest() {
        return Arrays.asList(
                new Object[]{new CalculatorV1()},
                new Object[]{new CalculatorV2()}
        );
    }

    public CalculatorInterface calculator;

    public CalculatorCommonTests(CalculatorInterface calculator) {
        this.calculator = calculator;
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
    public void testOneParamShouldReturnThatNumber () throws CalculatorException {
        assertTrue(1000 == calculator.sum("1000"));
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
