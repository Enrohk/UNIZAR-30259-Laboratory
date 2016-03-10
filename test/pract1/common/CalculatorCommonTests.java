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
                new Object[]{new CalculatorVersion1()},
                new Object[]{new CalculatorVersion2()},
                new Object[]{new CalculatorVersion3()},
                new Object[]{new CalculatorVersion4()},
                new Object[]{new CalculatorVersion5()}
        );
    }

    public CalculatorInterface calculator;

    public CalculatorCommonTests(CalculatorInterface calculator) {
        this.calculator = calculator;
    }


}
