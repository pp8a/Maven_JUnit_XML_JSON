package com.epam.rd.autotasks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class FactorialCsvParametrizedTesting {

    Factorial factorial = new Factorial();
    /**
     * Этот метод представляет сам параметризированный тест. 
     * @param input входные данные,  будут автоматически заполнены значениями из CSV файла.
     * @param output ожидаемый результат,  будут автоматически заполнены значениями из CSV файла.
     */
    @ParameterizedTest // Эта аннотация указывает, что следующий метод является параметризированным тестом.
    @CsvFileSource(resources = "/csvCases.csv") // Эта аннотация указывает источник данных для параметризированного теста. В данном случае данные берутся из CSV-файла csvCases.csv, который должен располагаться в директории resources проекта.
    void testFactorial(String input, String output){
    	// Convert the output to String, as values from CSV are read as String
    	String actual = factorial.factorial(input);
    	
    	assertEquals(actual, output);

    }
}
