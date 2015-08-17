package com.algorithms.wmatch;

/**
 * Determines the similarity between words using the Levenshtein Word Distance
 * algorithm.
 * 
 */
public class LevenshteinWordDistanceCalculator {
	/** The default instance of the class. */
	public static final LevenshteinWordDistanceCalculator DEFAULT = new LevenshteinWordDistanceCalculator(
			1, 1, 1);

	/** The unit cost of performing a substitution. */
	private final int costOfSubstitution;

	/** The unit cost of performing a deletion. */
	private final int costOfDeletion;

	/** The unit cost of performing an insertion. */
	private final int costOfInsertion;

	/**
	 * Constructor.
	 * 
	 * @param costOfSubstitution
	 *            The unit cost of performing a substitution.
	 * @param costOfDeletion
	 *            The unit cost of performing a deletion.
	 * @param costOfInsertion
	 *            The unit cost of performing an insertion.
	 */
	public LevenshteinWordDistanceCalculator(int costOfSubstitution,
			int costOfDeletion, int costOfInsertion) {
		this.costOfSubstitution = costOfSubstitution;
		this.costOfDeletion = costOfDeletion;
		this.costOfInsertion = costOfInsertion;
	}

	public int calculate(CharSequence source, CharSequence target) {
		int[][] grid = new int[target.length() + 1][source.length() + 1];

		for (int j = 0; j < grid[0].length; j++) {
			grid[0][j] = j;
		}

		for (int i = 0; i < grid.length; ++i) {
			grid[i][0] = i;
		}

		for (int i = 1; i < grid.length; ++i) {
			for (int j = 1; j < grid[0].length; j++) {
				grid[i][j] = min(grid[i-1][j-1]  + ((source.charAt(j - 1) == target.charAt(i - 1)) ? 0 : this.costOfSubstitution) , 
						grid[i-1][j] + this.costOfDeletion, grid[i][j-1]  + this.costOfInsertion );
			}
		}
		
		return grid[target.length()][source.length()];
	}

//	private int minCost(int[][] grid, int row, int col) {
//		return grid[row][col];
//	}
	
	private int min(int a, int b, int c) {
		return Math.min (Math.min(a, b), c);
	}
}
