package countingelements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermCheck {

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		PermCheck permCheck = new PermCheck();

		int[] permutationArray = {3, 1, 2, 4, 5};

		int expected = 1;

		System.out.println("Array to test: " + Arrays.toString(permutationArray));
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + permCheck.solution(permutationArray));
	}

	public int solution(int[] arrayToCheckIfPermutation) {
		int arrayLength = arrayToCheckIfPermutation.length;

		// use set to check if elements are distinct
		Set<Integer> permutationHelper = new HashSet<>();

		for (int i : arrayToCheckIfPermutation) {

			if (i > arrayLength || !permutationHelper.add(i)) {
				return 0;
			}
		}

		return 1;
	}
}
