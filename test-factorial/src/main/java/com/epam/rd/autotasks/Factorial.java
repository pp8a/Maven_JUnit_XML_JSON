package com.epam.rd.autotasks;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Factorial {
    public String factorial(String n) {
    	try {
    		BigInteger number = new BigInteger(n.trim());
    		   		
    		int num = number.compareTo(BigInteger.ZERO);    		
    		if(num < 0) {
    			throw new IllegalArgumentException("Factorial is defined only for non-negative integers: " + num);
    		}
    		
    		BigInteger result = Stream.iterate(BigInteger.ONE, t -> t.add(BigInteger.ONE))
    			.limit(number.intValue())
    			.reduce(BigInteger.ONE, BigInteger::multiply);
    		   		
    		return String.valueOf(result);
    		
		} catch (NumberFormatException | NullPointerException e) {
			throw new IllegalArgumentException("Unable to parse the input string to an integer: " + n);
		}
    	
//    	try {
//    		int num = Integer.parseInt(n);
//    		
//    		if(num < 0) {
//    			throw new IllegalArgumentException("Factorial is defined only for non-negative integers: " + num);
//    		}
//    		
//    		int result = IntStream.rangeClosed(2, num).reduce(1, (acc, x) -> acc * x);    		
//    		return String.valueOf(result);
//    		
//		} catch (NumberFormatException e) {
//			throw new IllegalArgumentException("Unable to parse the input string to an integer: " + n);
//		}
    }
}
