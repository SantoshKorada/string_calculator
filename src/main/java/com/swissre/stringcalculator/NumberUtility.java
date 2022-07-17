package com.swissre.stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtility {

	private String delimiter;

	public NumberUtility() {
		delimiter = "[,\n\\s]";
	}

	public List<Integer> convertStringToNumbers(String numbers) {
		return Arrays.stream(splitByDelimiter(numbers)).map(Integer::parseInt).collect(Collectors.toList());
	}

	private String extractDelimiter(String input) {
		String escInput;
		int substr_start = input.indexOf("\n");
		escInput = input.substring(0, substr_start).replace("[", "").replace("]", "").replace("//", "");
		return "\\Q" + escInput + "\\E";
	}

	private String[] splitByDelimiter(String numbers) {
		if (checkCustomDelimiter(numbers)) {
			return numbers.substring(numbers.indexOf("\n") + 1).split(extractDelimiter(numbers));
		}
		return numbers.split(delimiter);
	}

	private boolean checkCustomDelimiter(String numbers) {
		return numbers.startsWith("/");
	}

}
