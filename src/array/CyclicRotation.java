package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicRotation {

	public static void main(String[] args) {
		CyclicRotation cyclicRotation = new CyclicRotation();

		List<Integer> numberOfRotationsToTest = Arrays.asList(0, 1, 3, 26);
		List<int[]> combinationsToTest = new ArrayList<>();

		int[] arrayToTest1 = {1, 2, 3, 4};
		int[] arrayToTest2 = {-1000, -1000, -1000};

		combinationsToTest.add(arrayToTest1);
		combinationsToTest.add(arrayToTest2);

		List<int[]> expectedRotated1 = getExpectedRotatedList1();

		for (int i = 0; i < combinationsToTest.size(); i++) {
			int[] combinationToTest = combinationsToTest.get(i);
			for (int j = 0; j < numberOfRotationsToTest.size(); j++) {

				int[] expected = i == 0 ? expectedRotated1.get(j) : arrayToTest2;

				System.out.println("Integers array to shift: " + Arrays.toString(combinationToTest));
				System.out.println("Integers array to shift: " + numberOfRotationsToTest.get(j));
				System.out.println("Expected: " + Arrays.toString(expected));
				System.out.println("Actual: " + Arrays.toString(cyclicRotation.solution(combinationToTest, numberOfRotationsToTest.get(j))));
				System.out.println("----");
			}
		}
	}

	private static List<int[]> getExpectedRotatedList1() {
		List<int[]> expectedRotated1 = new ArrayList<>();

		int[] expected1 = {1, 2, 3, 4};
		int[] expected2 = {4, 1, 2, 3};
		int[] expected3 = {2, 3, 4, 1};
		int[] expected4 = {3, 4, 1, 2};

		expectedRotated1.add(expected1);
		expectedRotated1.add(expected2);
		expectedRotated1.add(expected3);
		expectedRotated1.add(expected4);
		return expectedRotated1;
	}

	public int[] solution(int[] arrayToRotate, int numberOfRotations) {
		if (arrayToRotate.length == 0) {
			return arrayToRotate;
		}

		int arrayToRotateLength = arrayToRotate.length;
		int maxRotations = numberOfRotations % arrayToRotateLength;
		int[] rotatedArray = new int[arrayToRotateLength];

		for (int i = 0; i < arrayToRotateLength; i++) {
			rotatedArray[(i + maxRotations) % arrayToRotateLength] = arrayToRotate[i];
		}

		return rotatedArray;
	}
}
