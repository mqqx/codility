package prefixsums;

import java.util.Arrays;

public class PassingCars {

	private static final int MAX_NUMBER_OF_PAIRS_PASSING = 1000000000;

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		PassingCars passingCars = new PassingCars();

		int[] carArray = {0, 1, 0, 1, 1};

		int expected = 5;

		System.out.println("Array to test: " + Arrays.toString(carArray));
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + passingCars.solution(carArray));
	}

	public int solution(int[] passingCars) {
		int numberOfPairs = 0;
		int numberOfCarsTravelingEast = 0;

		for (int car : passingCars) {

			if (car == 0) {
				numberOfCarsTravelingEast++;
			} else if (numberOfCarsTravelingEast > 0) {
				numberOfPairs += numberOfCarsTravelingEast;
				if (numberOfPairs > MAX_NUMBER_OF_PAIRS_PASSING) {
					return -1;
				}
			}
		}
		return numberOfPairs;
	}
}
