package com.algorithms.dp;

/**
 * Created by Usuario on 03/09/2016.
 */
// Grokking algorithms, page 178.
public class LongestCommonSubstring {
    private String string1;
    private String string2;
    private int[][] grid;
    private int solution;

    public LongestCommonSubstring(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;

        this.grid = new int[string1.length()][string1.length()];
    }

    public void fillSolutioArray() {
        this.solution = 0;

        for (int r = 0; r < string1.length(); r++) {
            for (int c = 0; c < string2.length(); c++) {
                if (string1.charAt(r) == string2.charAt(c)) {
                    if (r == 0 || c == 0) {
                        this.grid[r][c] = 1;
                    } else {
                        this.grid[r][c] = this.grid[r - 1][c - 1] + 1;
                    }
                    if (this.grid[r][c] > this.solution) {
                        this.solution = this.grid[r][c];
                    }
                }
            }
        }
    }

    public int getSolution() {
        return this.solution;
    }

    public static void main(String[] strings) {
        LongestCommonSubstring lcs = new LongestCommonSubstring("fish","fosh");
        lcs.fillSolutioArray();
        System.out.println(lcs.getSolution());
    }

}
