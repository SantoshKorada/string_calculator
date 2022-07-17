# String Calculator Application

# Testing Application
mvn clean test

#For Checking Add functionality

1. Create a driver or main class
2. Add the below code

public class StringCalculatorDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringCalculatorOperations calculatorOperations = new StringCalculatorOperations();
		int sum = 0;

		String numbers = "1,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6";
		sum = calculatorOperations.add(numbers);
		System.out.println("Sum :: " + sum);

		String numberswithspace = "1 2 3";
		sum = calculatorOperations.add(numberswithspace);
		System.out.println("Sum :: " + sum);

		String numbersWithDelimeres = "1,2\n3";
		sum = calculatorOperations.add(numbersWithDelimeres);
		System.out.println("Sum :: " + sum);

		String negativeNumbers = "-1,-2,-3,4,5,6,2,3,4,5,-6,2,3,4,-5,6,2,3,4,-5,-6,2,3,4,5,6,2,3,4,5,6";
		sum = calculatorOperations.add(negativeNumbers);
		System.out.println("Sum :: " + sum);

		String numberslistGreaterThan100 = "1,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,"
				+ "2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,"
				+ "2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,"
				+ "2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,"
				+ "3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,"
				+ "4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6,2,3,4,5,6";
		sum = calculatorOperations.add(numberslistGreaterThan100);
		System.out.println("Sum :: " + sum);

	}

}