package com.epam.rd.autotasks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class FactorialMethodSourceParametrizedTesting {

    Factorial factorial = new Factorial();
    /**
     * 
     * @MethodSource("testCases") предоставляет набор данных для теста
     * Эта аннотация указывает, что тест должен быть выполнен несколько раз, 
     * каждый раз с набором аргументов, полученных из метода с именем testCases.  
     * 
     * @param in
     * @param expected
     */
    @ParameterizedTest(name = "[{index}], {arguments}")
    @MethodSource("testCases")
    void testFactorial(String in, String expected) {
    	String actual = factorial.factorial(in);
    	
    	assertEquals(actual, expected);
    }
    
    @Test
    public static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("1", "1"),
                arguments("2", "2"), //import static org.junit.jupiter.params.provider.Arguments.arguments;
                Arguments.of("5", "120")                
        );
    }

//    @Test
//    public static Stream<String[]> testCases() {
//        return Stream.of(
//                new String[]{"1", "1"},
//                new String[]{"2", "2"},
//                new String[]{"5", "120"}//               
//        );
//    }
}
