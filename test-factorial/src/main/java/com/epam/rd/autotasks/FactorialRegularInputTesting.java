package com.epam.rd.autotasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FactorialRegularInputTesting {

    Factorial factorial = new Factorial();
    
    @Test
    void testFactorialOfZero() {
    	assertEquals("1", factorial.factorial("0"));
    }
    
    @Test
    void testFactorialOfPositiveNumber() {
    	assertEquals("120", factorial.factorial("5"));
    }
    
    @Test
    void testFactorialOfLargeNumber() {
    	assertEquals("3628800", factorial.factorial("10"));
    	assertEquals("2432902008176640000", factorial.factorial("20"));
    }
    
    @Test
    void testFactorialOfStringWithSpaces() {
        // Предположим, что ваша реализация может обрабатывать числа в виде строк
//        assertEquals("1", factorial.factorial("  1  "));
    	assertThrows(NumberFormatException.class, () -> factorial.factorial("  1  "));
    }
    
    @Test
    void testFactorialOfStringWithLeadingZeros() {
        // Предположим, что ваша реализация может обрабатывать числа в виде строк
        assertEquals("1", factorial.factorial("001"));
    }

}
