package countingelements;

import java.util.Arrays;

public class MaxCounters {

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		MaxCounters maxCounters = new MaxCounters();

		int[] leaves = {3, 4, 4, 6, 1, 4, 4};
		int numbersOfCounters = 5;

		int[] expected = {3, 2, 2, 4, 2};

		System.out.println("Array to test: " + Arrays.toString(leaves));
		System.out.println("Expected: " + Arrays.toString(expected));
		System.out.println("Actual: " + Arrays.toString(maxCounters.solution(numbersOfCounters, leaves)));
	}

	public int[] solution(int numberOfCounters, int[] operations) {

		int[] counters = new int[numberOfCounters];

		int highestCounter = 0;
		int lastHighestToFill = 0;
		for (int operation : operations) {
			if (operation > numberOfCounters) {
				if (highestCounter > 0) {
					lastHighestToFill = highestCounter;
				}
			} else {
				int counterToIncrease = operation - 1;

				if (counters[counterToIncrease] < lastHighestToFill) {
					counters[counterToIncrease] = lastHighestToFill + 1;
				} else {
					counters[counterToIncrease] += 1;
				}

				if (counters[counterToIncrease] > highestCounter) {
					highestCounter = counters[counterToIncrease];
				}
			}
		}

		// update all elements lower than the last highest counter which every number should be updated to
		for (int i = 0; i < counters.length; i++) {
			if (counters[i] < lastHighestToFill) {
				counters[i] = lastHighestToFill;
			}
		}

		return counters;
	}
}
