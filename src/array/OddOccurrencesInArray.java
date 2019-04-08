package array;

import java.util.Arrays;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        OddOccurrencesInArray oddOccurrencesInArray = new OddOccurrencesInArray();

    	int[] arrayToTest = {9, 3, 9, 3, 9, 7, 9, 7, 7, 7, 7};
        int expected = 7;
		System.out.println("Array to test: " + Arrays.toString(arrayToTest));
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + oddOccurrencesInArray.solution(arrayToTest));
	}


	public int solution(int[] arrayToFindOddElement) {
		int oddElement = 0;

		for (int valueToCheck : arrayToFindOddElement) {
			// use bitwise xor to determine the odd element
			oddElement ^= valueToCheck;
		}
		return oddElement;
	}

}
