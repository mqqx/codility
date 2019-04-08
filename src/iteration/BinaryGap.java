package iteration;

import java.util.Arrays;
import java.util.stream.Stream;

public class BinaryGap {
	public static void main(String[] args) {
		BinaryGap binaryGap = new BinaryGap();
		int[] positiveIntegersToCheckLongestBinaryGap = new int[]{1, 5, 32, 529, 1041};
		int[] expected = new int[]{0, 1, 0, 4, 5};

		int[] loopActual = new int[expected.length];
		int[] streamActual = new int[expected.length];

		for (int i = 0; i < positiveIntegersToCheckLongestBinaryGap.length; i++) {
			loopActual[i] = binaryGap.loopSolution(positiveIntegersToCheckLongestBinaryGap[i]);
			streamActual[i] = binaryGap.streamSolution(positiveIntegersToCheckLongestBinaryGap[i]);
		}

		System.out.println("Integers to check longest binary gap: " + Arrays.toString(positiveIntegersToCheckLongestBinaryGap));
		System.out.println("Expected: " + Arrays.toString(expected));
		System.out.println("Actual values with loop version: " + Arrays.toString(loopActual));
		System.out.println("Actual values with stream version: " + Arrays.toString(streamActual));
	}

	public int solution(int positiveIntegerToCheckLongestBinaryGap) {
//		return loopSolution(positiveIntegerToCheckLongestBinaryGap);
		return streamSolution(positiveIntegerToCheckLongestBinaryGap);
	}

	private int loopSolution(int positiveIntegerToCheckLongestBinaryGap) {
		// trim trailing zeros, as they are not relevant to get the longest gap


		String binaryInteger = Integer.toBinaryString(positiveIntegerToCheckLongestBinaryGap).replaceAll("0+$", "");

		int longestSequence = 0;
		int longestSequenceHelper = 0;
		int currentSeq = 0;

		for (int i = 0; i < binaryInteger.length(); i++) {

			char currentChar = binaryInteger.charAt(i);

			if (currentChar == '0') {
				currentSeq++;
			} else {
				currentSeq = 0;
				longestSequence = longestSequenceHelper;
			}

			if (currentSeq > longestSequence) {
				longestSequenceHelper = currentSeq;
			}
		}

		return longestSequence;
	}

	private int streamSolution(int positiveIntegerToCheckLongestBinaryGap) {
		return Stream
				.of(Integer.toBinaryString(positiveIntegerToCheckLongestBinaryGap)
						// trim trailing zeros, as they are not relevant to get the longest gap
						.replaceAll("0+$", "")
						// split string with all ones to get an array of zeros
						.split("1+"))
				// convert length of zero-strings to integer
				.map(String::length)
				// find the largest integer by using compare
				.max(Integer::compare)
				// return 0 if nothing matches after the process
				.orElse(0);
	}
}
