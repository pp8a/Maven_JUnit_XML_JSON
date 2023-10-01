package com.epam.rd.autotasks;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class QuadraticEquationTwoRootsCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    
    private final double a;
    private final double b;
    private final double c;
    private final String expected;

    public QuadraticEquationTwoRootsCasesTesting(double a, double b, double c, String expected) {
    	 this.a = a;
         this.b = b;
         this.c = c;
         this.expected = expected;
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{               
        	{1, 2, -3, "1.0 -3.0"},     // Уравнение вида: 1x^2 + 2x - 3 = 0
            {2, -5, -3, "3.0 -0.5"},    // Уравнение вида: 2x^2 - 5x - 3 = 0
            {2, -7, 3, "3.0 0.5"},
            {4, 0, -16, "2.0 -2.0"}      // Уравнение вида: 4x^2 - 16 = 0 (Разность квадратов)
        });
    }
    
//    @Test (expected = AssertionError.class)
//    public void testTwoRootsCase() {
////        assertEquals(expected, quadraticEquation.solve(a, b, c));    	
//        assertThat(quadraticEquation.solve(a, b, c), is(expected));
//        
//    } 
    
    @Test
    public void testTwoRootsCases() {
        String solved = quadraticEquation.solve(a, b, c);
        if (!solved.contains(" ") || solved.equals("no roots")) {
            throw new AssertionError();
        }
        String[] actual = solved.split(" ");
        assertTrue(expected.contains(actual[0]));
        assertTrue(expected.contains(actual[1]));
    } 
}
