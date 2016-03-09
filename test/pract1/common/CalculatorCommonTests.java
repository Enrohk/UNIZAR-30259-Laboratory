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
                new Object[]{new CalculatorV2()},
                new Object[]{new CalculatorV3()},
                new Object[]{new CalculatorV4()},
                new Object[]{new CalculatorV5()}
        );
    }

    public CalculatorInterface calculator;

    public CalculatorCommonTests(CalculatorInterface calculator) {
        this.calculator = calculator;
    }


}
