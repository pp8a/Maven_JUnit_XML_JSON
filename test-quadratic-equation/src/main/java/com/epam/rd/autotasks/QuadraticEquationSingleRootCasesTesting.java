package com.epam.rd.autotasks;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class QuadraticEquationSingleRootCasesTesting {
    protected QuadraticEquation quadraticEquation = new QuadraticEquation();
    
    private double a;
    private double b;
    private double c;
    private double expected;

    public QuadraticEquationSingleRootCasesTesting(double a, double b, double c, double expected) {
    	 this.a = a;
         this.b = b;
         this.c = c;
         this.expected = expected;
    }
    
    @Parameters
    public static Collection<Object[]> data(){
    	return Arrays.asList(new Object[][]{
    		{1, 0, 0, -0.0},     // Уравнение вида: 1x^2 + 0x + 0 = 0
    	    {1, -2, 1, 1.0},    // Уравнение вида: 1x^2 - 2x + 1 = 0 (Квадратный трином)
    	    {1, 2, 1, -1.0},    // Уравнение вида: 1x^2 + 2x + 1 = 0 (Квадратный трином)
    	    {4, -8, 4, 1.0}     // Уравнение вида: 4x^2 - 8x + 4 = 0 (Квадратный трином)		
            
    	});
    }
    
    @Test
    public void testSingleRootCase() {  
//    	assertEquals(expected, quadraticEquation.solve(a, b, c));
    	assertThat(String.valueOf(expected), is(quadraticEquation.solve(a, b, c)));
    	
    }   
    
    @BeforeClass
    public static void setUp() {
        Locale.setDefault(Locale.ENGLISH);
    }
    
}