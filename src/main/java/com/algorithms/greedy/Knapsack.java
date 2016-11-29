package com.algorithms.greedy;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Solution by LAzuaje
 *
 * Problem source: Coursera, School of Economics, Specialization: Data Structures and Algorithms,
 *
 * Problem Description
 *
 *         Fractional Knapsack.
 *
 *         Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
 *         Input Format. The rst line of the input contains the number n of items and the capacity W of a knapsack.
 *         The next n lines dene the values and weights of the items. The i-th line contain integers vi and wi |
 *         the value and the weight of i-th item, respectively.
 *         Constraints. 1  n  103, 0  W  2  106; 0  vi  2  106, 0 < wi  2  106 for all 1  i  n. All the
 *         numbers are integers.
 *         Output Format. Output the maximal value of fractions of items that t into the knapsack. The absolute
 *         value of the dierence between the answer of your program and the optimal value should be at most
 *         10?3. To ensure this, output your answer with at least four digits after the decimal point (otherwise
 *         your answer, while being computed correctly, can turn out to be wrong because of rounding issues).
 *         Time Limits. C: 1 sec, C++: 1 sec, Java: 1.5 sec, Python: 5 sec.
 *         Memory Limit. 64Mb.
 *
 *         Sample 1.
 *         Input:
 *         3 50
 *         60 20
 *         100 50
 *         120 30
 *         Output:
 *         180.0000
 *         Explanation:
 *         To achieve the value 180, we take the rst item and the third item into the bag.
 *
 *         Sample 2.
 *         Input:
 *         1 10
 *         500 30
 *         Output:
 *         166.6667
 *         Explanation:
 *         Here, we just take one third of the only available item.
 *
 *         Approach: Greedy algorithm.
 *
 */

public class Knapsack {
    private int capacity;
    private Unit[] units;

    public Knapsack(int capacity, int[] values, int[] weights) {
        this.capacity = capacity;
        this.units = new Unit[values.length];

        for (int i = 0; i < values.length; i++) {
            units[i] = new Unit(values[i], weights[i]);
        }

        Arrays.sort(units, new Comparator<Unit>() {
            public int compare(Unit o1, Unit o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public int getCapacity() {
        return this.capacity;
    }

    /**
     * @return the value of the collected items.
     */
    public int find() {
        int c = this.capacity;
        int max = 0;

        int i = 0;
        Unit unit;

        while (true) {
            if (c < units[i].getWeight()) {
                break;
            }
            max += (c / units[i].getWeight()) * units[i].getValue();
            c = c % units[i].getWeight();
            i++;
        }

        return max;
    }

    Unit[] getUnits() {
        return this.units;
    }


    /**
     * Helper class to represent the coefficient value / weight.
     */
    private class Unit implements Comparable {
        private int value, weight;
        private float rate;

        public Unit(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.rate = ((float) this.value) / this.weight;
        }

        public int getValue() {
            return this.value;
        }

        public int getWeight() {
            return this.weight;
        }


        public float getRate() {
            return this.rate;
        }

        public String toString() {
            return "Unit: rate " + this.rate + " , value " + value + " , weight " + weight;
        }

        public int compareTo(Object o) {
            Unit other = (Unit) o;
            return  this.rate > other.rate ? 1 :  this.rate == other.rate ? 0 : -1;
        }
    }

    static void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int capacity = in.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = in.nextInt();
            values[i] = in.nextInt();
        }

        Knapsack f = new Knapsack(capacity, values, weights);
        out.println(f.find());
    }

    static void run() {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try {
            // After use resources are closed by the application.
            // Read from keyboard, write to screen.
            in = new Scanner(System.in);
            solve(in, out);
        } catch (Exception exception) {
            //   throw new Error(exception);
        } finally {
            in.close();
            out.close();
        }
    }

    public static void main(String[] strings) {
        Knapsack.run();
    }
}
