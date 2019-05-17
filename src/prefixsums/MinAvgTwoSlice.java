package prefixsums;

import java.util.Arrays;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

		int[] integersToSlice = {-3, -5, -8, -4, -10};

		int expected = 2;

		System.out.println("Array to test: " + Arrays.toString(integersToSlice));
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + minAvgTwoSlice.solution(integersToSlice));
	}

	public static int avgRoundedUp(int dividend) {
		int divisor = 2;
		int roundedTowardsZeroQuotient = dividend / divisor;
		boolean dividedEvenly = (dividend % divisor) == 0;
		if (dividedEvenly) {
			return roundedTowardsZeroQuotient;
		}

		boolean wasRoundedDown = dividend > 0;
		if (wasRoundedDown) {
			return roundedTowardsZeroQuotient + 1;
		}

		return roundedTowardsZeroQuotient;
	}

	public int solution(int[] integersToSlice) {
		int smallestStartingPosition = 0;

		int from = integersToSlice[0];
		int to = integersToSlice[1];
		int avg = avgRoundedUp(from + to);
		System.out.println(avg);

		for (int i = 2; i < integersToSlice.length; i++) {

			int fromIndex = i - 1;
			from = integersToSlice[fromIndex];
			to = integersToSlice[i];

			int currentAvg = avgRoundedUp(from + to);
			System.out.println(currentAvg);

			if (currentAvg < avg) {
				avg = currentAvg;
				smallestStartingPosition = fromIndex;
			}
		}

		return smallestStartingPosition;
	}
}
