package prefixsums;

import java.util.Arrays;

public class GenomicRangeQuery {

	public static void main(String[] args) {
		// create an object of this class to have easy access to the solution method without modifying its definition
		GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();

		String dnaSequence = "CAGCCTA";
		int[] queryFrom = {2, 5, 0};
		int[] queryTo = {4, 5, 6};
		int[] expected = {2, 4, 1};

		System.out.println("DNA sequence \"" + dnaSequence + "\" to query from " + Arrays.toString(queryFrom) + " to " + Arrays.toString(queryTo));
		System.out.println("Expected: " + Arrays.toString(expected));
		System.out.println("Actual: " + Arrays.toString(genomicRangeQuery.solution(dnaSequence, queryFrom, queryTo)));
	}

	public int[] solution(String dnaSequence, int[] queryFrom, int[] queryTo) {

		int[] lowestImpactFactors = new int[queryFrom.length];

		for (int i = 0; i < queryFrom.length; i++) {

			String subDnaSequence = dnaSequence.substring(queryFrom[i], queryTo[i] + 1);

			char lowestNucleotide = 'T';
			for (int j = 0; j < subDnaSequence.length(); j++) {
				char nucleotide = subDnaSequence.charAt(j);

				if (nucleotide < lowestNucleotide) {
					lowestNucleotide = nucleotide;
					if (lowestNucleotide == 'A') {
						break;
					}
				}
			}
			lowestImpactFactors[i] = lowestNucleotide == 'A' ? 1 : lowestNucleotide == 'C' ? 2 : lowestNucleotide == 'G' ? 3 : 4;
		}
		return lowestImpactFactors;
	}
}
