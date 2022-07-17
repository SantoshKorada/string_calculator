package com.swissre.stringcalculator;

import java.util.List;
import java.util.stream.Collectors;

public class StringCalculatorOperations {

	private NumberUtility numberUtility = new NumberUtility();

	public int add(String numbers) {
		if (numbers == null || numbers == "")
			return 0;
		return sumOfNumbers(numbers);
	}

	private void checkNegativeNumbers(List<Integer> numbersList) {
		List<Integer> negativeNumbersList = numbersList.stream().filter(i -> i < 0).collect(Collectors.toList());
		if (negativeNumbersList.size() > 0)
			throw new StringCalculatorException("Negative numbers are not allowed :: " + negativeNumbersList);
	}

	private int sumOfNumbers(String numbers) {
		List<Integer> numbersList = numberUtility.convertStringToNumbers(numbers);
		checkNegativeNumbers(numbersList);
		if (numbersList.size() > 100)
			throw new StringCalculatorException(
					"Number list is more than 100 Numbers, So the ADD operation is ignored");
		return numbersList.stream().mapToInt(i -> i.intValue()).sum();
	}

}
