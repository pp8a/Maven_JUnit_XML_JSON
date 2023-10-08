package com.example.SortingApp;

import java.util.Arrays;

/**
 * The {@code App} class is a simple Java application that takes command-line arguments,
 * sorts them in ascending order, and prints the sorted numbers.
 * 
 * <p>
 * Usage:
 * <pre>
 * java App [integer1] [integer2] ... [integerN]
 * </pre>
 * 
 * 
 * <p>
 * The application supports up to 10 integer values as command-line arguments. If more
 * than 10 arguments are provided, it will display an error message.
 * </p>
 * 
 * <p>
 * If any of the provided arguments is not a valid integer, the application will display
 * an error message and exit.
 * </p>
 * 
 * <p>
 * The sorted numbers will be printed to the standard output.
 * </p>
 * 
 * <p>
 * Example:
 * <pre>
 * java App 5 3 9 1 9 2 7 2
 * </pre>
 * Output:
 * <pre>
 * Sorted numbers [1, 2, 2, 3, 5, 7, 9, 9]
 * </pre>
 * 
 * 
 * @author Aleksandr Mikhalchuk
 * @version 1.0
 */
public class App 
{
/**
 * The main method of the application.
* 
* <p>
 * This method processes the command-line arguments, validates and parses them into
* an array of integers, sorts the integers, and prints the result.
* </p>
* 
* <p>
* If there are more than 10 arguments, it displays an error message and exits.
* If any of the arguments is not a valid integer, it displays an error message and exits.
* </p>
* 
* @param args The command-line arguments containing integer values.
*/
    public static void main( String[] args )
    {
    	if(args.length > 10) {    	
        	System.out.println("Too many arguments. Please provide up to 10 integer values.");
        }
        
        int[] numbers = new int [args.length];
        for (int i = 0; i < numbers.length; i++) {
			try {
				numbers[i] = Integer.parseInt(args[i]);
			} catch (NumberFormatException e) {
				System.out.println("Invalid argument: " + args[i] + " Please provide only integer values");
				return;
			}
		}
        
        Arrays.sort(numbers);        
        System.out.println("Sorted numbers " + Arrays.toString(numbers));
    }
/**
 * by default
 */
public App() {
	super();
	// TODO Auto-generated constructor stub
}
    
    
}
