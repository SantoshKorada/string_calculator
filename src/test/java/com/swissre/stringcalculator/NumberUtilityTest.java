package com.swissre.stringcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class NumberUtilityTest {

	private NumberUtility numberUtility;
	private String inputNumbers;
	private List<Integer> expectedOutput;

	@Before
	public void before() {
		numberUtility = new NumberUtility();
	}

	public NumberUtilityTest() {

	}

	@Test
	public void convert_string_to_numbers() {
		expectedOutput = Arrays.asList(1, 2, 3);
		inputNumbers = "1,2,3";
		assertEquals(expectedOutput, numberUtility.convertStringToNumbers(inputNumbers));
	}

	@Test
	public void convert_string_delimetres_to_numbers() {
		expectedOutput = Arrays.asList(1, 2, 3);
		inputNumbers = "1\n2\n3";
		assertEquals(expectedOutput, numberUtility.convertStringToNumbers(inputNumbers));
	}

	@Test
	public void convert_string_delimetres_to_numbers_1() {
		expectedOutput = Arrays.asList(1, 2);
		inputNumbers = "//;\n1;2";
		assertEquals(expectedOutput, numberUtility.convertStringToNumbers(inputNumbers));
	}

	@Test
	public void convert_string_delimetres_to_numbers_2() {
		expectedOutput = Arrays.asList(1, 2, 3);
		inputNumbers = "//[***]\n1***2***3";
		assertEquals(expectedOutput, numberUtility.convertStringToNumbers(inputNumbers));
	}

}
