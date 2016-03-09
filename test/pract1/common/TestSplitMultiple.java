/*
This class is implemented to ensure that the Regular Expression
to split works fine in multiple cases
 */

package pract1.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class TestSplitMultiple {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new String[] {"1","2","3"}, "1*2-3", "//*-\n"},
                {new String[] {"1","2","3"}, "1*2-3", "//-*\n"},   //Order not matters
                {new String[] {"1","2","3"}, "1**2-3", "//*-\n"}   //Long splitters works
        });
    }



    private String[] expected;
    private String split,splitExpReg;

    public TestSplitMultiple (String[] expected, String split, String splitExpReg)
    {
        this.expected = expected;
        this.split = split;
        this.splitExpReg = splitExpReg;
    }

    @Test
    public void test ()
    {
        assertArrayEquals(expected, split.split(Operations.getRegExp(splitExpReg)));
    }


}
