package timeComplexity;

public class FrogJmp {

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		FrogJmp frogJmp = new FrogJmp();

		int startPosition = 10;
		int endPosition = 85;
		int fixedSteps = 30;

		int expected = 3;

		System.out.println("Start position: " + startPosition);
		System.out.println("End position: " + endPosition);
		System.out.println("Fixed steps: " + fixedSteps);

		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + frogJmp.solution(startPosition, endPosition, fixedSteps));
	}

	public int solution(int startPosition, int endPosition, int fixedSteps) {

		int jumps = 0;

		// no need to jump if start position == end position
		if (startPosition < endPosition) {
			// just calculate jumps with int
			jumps = (endPosition - startPosition) / fixedSteps;

			// if there is still a remainder add one more jump
			if ((endPosition - startPosition) % fixedSteps != 0) {
				jumps++;
			}
		}

		return jumps;
	}


}
