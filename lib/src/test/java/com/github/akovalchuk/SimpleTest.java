package com.github.akovalchuk;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SimpleTest {

    @Test
    public void testThis() throws Exception {
        assertTrue(true);
        System.out.println("benchmark");
    }
    
}
