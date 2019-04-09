package countingelements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		FrogRiverOne frogRiverOne = new FrogRiverOne();

		int[] leaves = {1, 3, 1, 3, 2, 1, 3};
		int leavesToJump = 3;

		int expected = 4;

		System.out.println("Array to test: " + Arrays.toString(leaves));
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + frogRiverOne.solution(leavesToJump, leaves));
	}

	public int solution(int leavesToJump, int[] leaves) {
		if (leavesToJump > leaves.length) {
			return -1;
		}

		// use set to check if all positions are covered in leaves
		Set<Integer> jumpedLeaves = new HashSet<>();

		boolean targetLeafReached = false;
		for (int i = 0; i < leaves.length; i++) {
			jumpedLeaves.add(leaves[i]);

			if (leaves[i] == leavesToJump) {
				targetLeafReached = true;
			}

			if (targetLeafReached && jumpedLeaves.size() >= leavesToJump) {
				return i;
			}
		}

		return -1;
	}
}
