package prefixsums;

import java.util.Arrays;

public class MinAvgTwoSlice {

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

		int[] integersToSlice = {4, 2, 2, 5, 1, 5, 8};

		int expected = 1;

		System.out.println("Array to test: " + Arrays.toString(integersToSlice));
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + minAvgTwoSlice.solution(integersToSlice));
	}

	public int solution(int[] integersToSlice) {
		int smallestStartingPosition = 0;

		return smallestStartingPosition;
	}
}
