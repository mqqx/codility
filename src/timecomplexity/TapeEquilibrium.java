package timecomplexity;

import java.util.Arrays;

public class TapeEquilibrium {
	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();

		int[] arrayToTest = {3, 1, 2, 4, 5};

		int expected = 3;

		System.out.println("Array to test: " + Arrays.toString(arrayToTest));

		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + tapeEquilibrium.solution(arrayToTest));
	}

	public int solution(int[] arrayToFindValueMedian) {
		int arrayLen = arrayToFindValueMedian.length;

		// sum of all entries from [1] to [arrayLen-1], so all from the right
		int sumRight = 0;
		// sum of all entries from the left, so just start with value at [0]
		int sumLeft = arrayToFindValueMedian[0];

		for (int i = 1; i < arrayLen; i++) {
			sumRight += arrayToFindValueMedian[i];
		}

		// calculate the starting diff
		int lowestDiff = Math.abs(sumLeft - sumRight);
		int diff;

		// proceed from left to right (add to sumLeft while remove value from sumRight)
		for (int i = 1; i < arrayLen-1; i++) {
			sumLeft += arrayToFindValueMedian[i];

			sumRight -= arrayToFindValueMedian[i];
			diff = Math.abs(sumRight - sumLeft);
			if (diff < lowestDiff) {
				lowestDiff = diff;
			}
		}

		return lowestDiff;
	}
}
