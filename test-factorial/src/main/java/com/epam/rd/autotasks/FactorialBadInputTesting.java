package com.epam.rd.autotasks;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullSource;
/**
 * корректно обрабатывает некорректные входные данные и выбрасывает исключение в случае необходимости
 */
class FactorialBadInputTesting {

    Factorial factorial = new Factorial();
    
    @Test
    @NullSource
    void testNullInput(){
    	assertThrows(IllegalArgumentException.class, () -> factorial.factorial(null));
//    	Exception exception =  assertThrows(IllegalArgumentException.class, () -> factorial.factorial(null));
//    	assertEquals("Cases of zero-value input", exception.getMessage());
    }
    
    //JUnit4
//    @Test(expected = IllegalArgumentException.class)
//    public void testNullInput() {
//        factorial.factorial(null);
//    }

    @Test
    void testNegativeInput(){
    	assertThrows(IllegalArgumentException.class, () -> factorial.factorial("-5"));
    }

    @Test
    void testFractionalInput(){
    	assertThrows(IllegalArgumentException.class, () -> factorial.factorial("3.4"));
    }

    @Test
    void testNonDigitalInput(){
    	assertThrows(IllegalArgumentException.class, () -> factorial.factorial("abc"));
    }


}
