package com.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

// Source: Grooking Algorithms, page 161.

public class Knapsack {
    private int capacity;
    private int rows;
    private List<Item> items;
    private float[][] array;

    public Knapsack(int capacity, List<Item> items) {
        this.capacity = capacity + 1;
        this.items = items;
        rows = items.size() + 1;
        array = new float[rows][this.capacity];
    }

    public void fillSolutionArray() {
        float previous;

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                // Find the (i-1,j) value of the array.
                previous = findCell(i - 1, j);
                // Check whether there is still weight available.
                if (items.get(i - 1).getWeight() > j) {
                    // Copy the previous value into the cell.
                    this.array[i][j] = previous;
                } else if (items.get(i - 1).getWeight() == j) {
                    this.array[i][j] = Math.max(previous, items.get(i - 1).getValue());
                } else {
                    this.array[i][j] = Math.max(previous, items.get(i - 1).getValue() + this.array[i - 1][j - items.get(i - 1).getWeight()]);
                }
            }
        }
    }

    public float getSolution() {
        return this.array[this.getRows() - 1][this.getCapacity() - 1];
    }

    private float findCell(int i, int j) {
        return array[i][j];
    }

    public int getRows() {
        return this.rows;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public float[][] getArray() {
        return array;
    }

    public static void main(String[] strings) {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Guiter", 1, 1500));
        items.add(new Item("Stereo", 4, 3000));
        items.add(new Item("Laptop", 3, 2000));
        Knapsack knapsack = new Knapsack(4, items);
        knapsack.fillSolutionArray();
        // 3500 expected
        System.out.println(knapsack.getSolution());
    }
}
