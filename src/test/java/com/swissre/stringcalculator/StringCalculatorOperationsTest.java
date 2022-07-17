package com.swissre.stringcalculator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorOperationsTest {

	private StringCalculatorOperations stringCalculatorOperations;

	@Before
	public void before() {
		stringCalculatorOperations = new StringCalculatorOperations();
	}

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void return_empty_sum_0() {
		assertThat(stringCalculatorOperations.add(""), is(0));
	}

	@Test
	public void return_sum_11() {
		assertThat(stringCalculatorOperations.add("11"), is(11));
	}

	@Test
	public void return_sum_35() {
		assertThat(stringCalculatorOperations.add("24,11"), is(35));
	}

	@Test
	public void return_sum_21() {
		assertThat(stringCalculatorOperations.add("1,2,3,4,5,6"), is(21));
	}
	@Test
	public void return_withspaces_sum_21() {
		assertThat(stringCalculatorOperations.add("1 2 3 4 5 6"), is(21));
	}
	@Test
	public void return_sum_33() {
		assertThat(stringCalculatorOperations.add("11,11,11"), is(33));
	}

	@Test
	public void return_sum_0() {
		assertThat(stringCalculatorOperations.add(null), is(0));
	}
	@Test
	public void return_sum_6() {
		assertThat(stringCalculatorOperations.add("1,2\n3"), is(6));
	}

	@Test
	public void return_sum_3_with_custom_delimiter_1() {
		assertThat(stringCalculatorOperations.add("//'\n1'2"), is(3));
	}

	@Test
	public void return_sum_3_with_custom_delimiter_2() {
		assertThat(stringCalculatorOperations.add("//;\n1;2"), is(3));
	}

	@Test
	public void return_sum_3_with_custom_delimiter_3() {
		assertThat(stringCalculatorOperations.add("//z\n1z2"), is(3));
	}

	@Test
	public void return_sum_15() {
		assertThat(stringCalculatorOperations.add("//[***]\n9***4***2"), is(15));
	}

	@Test
	public void throw_exception_negative_numbers_not_allowed() {
		expectedException.expect(StringCalculatorException.class);
		expectedException.expectMessage("Negative numbers are not allowed :: [-1]");
		stringCalculatorOperations.add("-1");
	}

	@Test
	public void throw_exception_multiple_negative_numbers_not_allowed() {
		expectedException.expect(StringCalculatorException.class);
		expectedException.expectMessage("Negative numbers are not allowed :: [-1, -2]");
		stringCalculatorOperations.add("-1,-2");
	}

	@Test
	public void throw_exception_greaterthan_100_numbers() {
		expectedException.expect(StringCalculatorException.class);
		expectedException.expectMessage("Number list is more than 100 Numbers, So the ADD operation is ignored");
		String numberslistGreaterThan100 = "1,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,"
				+ "2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,"
				+ "2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,"
				+ "2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,"
				+ "3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,"
				+ "4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6";
		stringCalculatorOperations.add(numberslistGreaterThan100);
	}
}
