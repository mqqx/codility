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

	// adapted solution https://stackoverflow.com/questions/19552754/java-codility-training-genomic-range-query
	public int[] solution(String dnaSequence, int[] queryFrom, int[] queryTo) {

		// https://codility.com/media/train/3-PrefixSums.pdf
		int[][] genomes = new int[3][dnaSequence.length() + 1];

		short nucleotideA, nucleotideC, nucleotideG;
		for (int i = 0; i < dnaSequence.length(); i++) {
			nucleotideA = 0;
			nucleotideC = 0;
			nucleotideG = 0;

			if ('A' == (dnaSequence.charAt(i))) {
				nucleotideA = 1;
			} else if ('C' == (dnaSequence.charAt(i))) {
				nucleotideC = 1;
			} else if ('G' == (dnaSequence.charAt(i))) {
				nucleotideG = 1;
			}

			genomes[0][i + 1] = genomes[0][i] + nucleotideA;
			genomes[1][i + 1] = genomes[1][i] + nucleotideC;
			genomes[2][i + 1] = genomes[2][i] + nucleotideG;
		}

		int[] lowestImpactFactors = new int[queryFrom.length];

		for (int i = 0; i < queryFrom.length; i++) {

			int queryFromIndex = queryFrom[i];
			int queryToIndex = queryTo[i] + 1;

			if (genomes[0][queryToIndex] - genomes[0][queryFromIndex] > 0) {
				lowestImpactFactors[i] = 1;
			} else if (genomes[1][queryToIndex] - genomes[1][queryFromIndex] > 0) {
				lowestImpactFactors[i] = 2;
			} else if (genomes[2][queryToIndex] - genomes[2][queryFromIndex] > 0) {
				lowestImpactFactors[i] = 3;
			} else {
				lowestImpactFactors[i] = 4;
			}
		}
		return lowestImpactFactors;
	}
}
