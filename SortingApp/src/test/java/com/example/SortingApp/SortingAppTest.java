package com.example.SortingApp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * The {@code SortingAppTest} class contains JUnit tests for the {@code App} class.
 * 
 * <p>
 * These tests cover the sorting functionality of the {@code App} class.
 * </p>
 * 
 * <p>
 * The class is designed to use the JUnit 4.12 testing framework.
 * </p>
 * 
 * <p>
 * Each test case is parameterized with a set of command-line arguments and the expected
 * sorted result.
 * </p>
 * 
 * @author Aleksandr Mikhalchuk
 * @version 1.0
 */

@RunWith(Parameterized.class)
public class SortingAppTest {
	private String[] args;
	private int[] expectedSort;
	
	/**
     * Constructs a new instance of {@code SortingAppTest} with the specified parameters.
     * 
     * @param args          The command-line arguments to be tested.
     * @param expectedSort  The expected result after sorting the arguments.
     */
	public SortingAppTest(String[] args, int[] expectedSort) {
		super();
		this.args = args;
		this.expectedSort = expectedSort;
	}
	
	/**
     * Provides parameters for the parameterized tests.
     * 
     * @return A collection of test data, where each item is an array consisting of
     *         command-line arguments and the expected sorted result.
     */	
	@Parameters
	public static Collection<Object[]> data(){
		List<Object[]> listData = new ArrayList<>();
		
		try {
			String currentDirectory = System.getProperty("user.dir");
			File input = new File(currentDirectory + "/src/main/resources/test_data.txt");
			try (Scanner in = new Scanner(input)) {
				while (in.hasNextLine()) {
					String line = in.nextLine();
					
					if(line.isEmpty()) {//Case with zero arguments
						listData.add(new Object[] {new String[]{}, new int[]{}});					
					}else {
						String[] tokens = line.trim().split("\\s+");
						int[] numbers = new int[tokens.length];
						for (int i = 0; i < numbers.length; i++) {
							numbers[i] = Integer.parseInt(tokens[i]);
						}
						
						Arrays.sort(numbers);
						
						listData.add(new Object[] {tokens, numbers});
					}
					
					
				}
			} catch (NumberFormatException e) {
				System.out.println("Scanner: " + e.getMessage());
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound: " + e.getLocalizedMessage());
		}
		
		return listData;
//		return Arrays.asList(new Object[][] {
//			{new String[]{"3", "1", "2"}, new int[]{1, 2, 3}},
//			{new String[]{}, new int[]{}},//Case with zero arguments
//			{new String[]{"5"}, new int[]{5}},//Case with one argument 
//			{new String[]{"9", "6", "7", "5", "3", "4", "1", "0", "2", "8"}, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}},//Case with ten arguments
//			{new String[]{"8", "9", "6", "2", "7", "5", "3", "4", "4", "1", "0", "2", "8"}, new int[]{0, 1, 2, 2, 3, 4, 4, 5, 6, 7, 8, 8, 9}}
//				//Case with more than 10 arguments				
//		});
	}

	/**
     * Tests the main sorting functionality of the {@code App} class.
     */
	@Test
	public void testMain() {
		// Convert command-line arguments to integers and sort
		int[] actual = Arrays.stream(args)
			.mapToInt(Integer::parseInt)
			.toArray();
		Arrays.sort(actual);
		
		// Verify that the actual result matches the expected result
		assertArrayEquals(expectedSort, actual);
	}
}
