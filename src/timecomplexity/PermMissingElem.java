package timecomplexity;

import java.util.Arrays;

public class PermMissingElem {
	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		PermMissingElem permMissingElem = new PermMissingElem();


		int[] arrayToTest = {};

		int expected = 1;

		System.out.println("Array to test: " + Arrays.toString(arrayToTest));

		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + permMissingElem.solution(arrayToTest));
	}

	public int solution(int[] arrayWithMissingElement) {

		if (arrayWithMissingElement.length == 0) {
			return 1;
		}

		// length + 1 because the missing element needs to be added as well
		long arrayLength = arrayWithMissingElement.length + 1;
		long sumOfAllElements = arrayLength * (arrayLength + 1) / 2;

		for (int value : arrayWithMissingElement) {
			sumOfAllElements -= value;
		}

		// as defined all integers of arrayWithMissingElement are between 0 and 100,000 so a cast to int will be safe
		return (int) sumOfAllElements;
	}
}
