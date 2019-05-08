package countingelements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		MissingInteger missingInteger = new MissingInteger();

		int[] missingIntegerArray = {1, 3, 6, 4, 1, 2};

		int expected = 5;

		System.out.println("Array to test: " + Arrays.toString(missingIntegerArray));
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + missingInteger.solution(missingIntegerArray));
	}

	public int solution(int[] missingIntegerArray) {
		Set<Integer> distinctPositiveValues = new HashSet<>();
		for (int value : missingIntegerArray) {
			if (value > 0) {
				distinctPositiveValues.add(value);
			}
		}

		int numberOfDistinctPositiveValues = distinctPositiveValues.size();

		for (int i = 1; i <= numberOfDistinctPositiveValues + 1; i++) {
			if (!distinctPositiveValues.contains(i)) {
				return i;
			}
		}

		if (numberOfDistinctPositiveValues > 0) {
			return numberOfDistinctPositiveValues * (numberOfDistinctPositiveValues + 1) / 2;
		}

		return 1;
	}
}
