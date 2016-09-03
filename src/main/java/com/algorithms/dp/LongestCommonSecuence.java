package com.algorithms.dp;

/**
 * Created by Usuario on 03/09/2016.
 */
// Grokking algorithms, page 178.
public class LongestCommonSecuence {
    private String string1;
    private String string2;
    private int[][] grid;
    private int solution;

    public LongestCommonSecuence(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;

        this.grid = new int[string1.length() + 1][string2.length() + 1];
    }

    public void fillSolutioArray() {
        this.solution = 0;

        for (int r = 1; r <= string1.length(); r++) {
            for (int c = 1; c <= string2.length(); c++) {
                if (string1.charAt(r-1) == string2.charAt(c-1)) {
                    this.grid[r][c] = this.grid[r - 1][c - 1] + 1;
                } else {
                    // Copy the max of the previous column and previous row.
                    this.grid[r][c] = Math.max(this.grid[r][c - 1], this.grid[r - 1][c]);
                }
            }
        }
    }

    public int getSolution() {
        return this.grid[string1.length()][string2.length()];
    }

    public static void main(String[] strings) {
        LongestCommonSecuence lcs = new LongestCommonSecuence("fish", "fosh");
        lcs.fillSolutioArray();
        System.out.println(lcs.getSolution());

        lcs = new LongestCommonSecuence("fort", "fosh");
        lcs.fillSolutioArray();
        System.out.println(lcs.getSolution());

        lcs = new LongestCommonSecuence("blue", "clues");
        lcs.fillSolutioArray();
        System.out.println(lcs.getSolution());
    }
}
