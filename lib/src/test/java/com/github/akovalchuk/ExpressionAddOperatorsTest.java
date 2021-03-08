package com.github.akovalchuk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ExpressionAddOperatorsTest {

    private static ExpressionAddOperators solution;
    
    @BeforeClass
    public static void init() {
        solution = new ExpressionAddOperators();
    }

    @Test
    public void calculateTest() throws Exception {
        String test = "1*2*3*4*5-6+78-9";
        int expected = 1*2*3*4*5-6+78-9;
        int actual = solution.calculate(test);
        Assert.assertEquals(expected, actual);

        test = "1*2*3*4*5-6-78+9";
        expected = 1*2*3*4*5-6-78+9;
        actual = solution.calculate(test);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void resultTest1() throws Exception {
        String test = "000";
        String[] expArr = {
            "0*0*0",
            "0*0+0",
            "0*0-0",
            "0+0*0",
            "0+0+0",
            "0+0-0",
            "0-0*0",
            "0-0+0",
            "0-0-0"
        };
        var expList = new ArrayList<String>();
        Collections.addAll(expList, expArr);
        Collections.sort(expList);
        List<String> actList = solution.addOperators(test, 0);
        Collections.sort(actList);
        Assert.assertArrayEquals(expList.toArray(), actList.toArray());
    }

    @Test
    public void resultTest2() throws Exception {
        String test = "2147483647";
        String[] expArr = {
            "2147483647",
        };
        var expList = new ArrayList<String>();
        Collections.addAll(expList, expArr);
        Collections.sort(expList);
        List<String> actList = solution.addOperators(test, 2147483647);
        Collections.sort(actList);
        Assert.assertArrayEquals(expList.toArray(), actList.toArray());
    }

}
