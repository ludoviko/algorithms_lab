package com.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

// Source: Grooking Algorithms, page 161.

public class Knapsack {
    private int capacity;
    private int rows;
    private List<Item> items;
    private float[][] array;
    private float granularity;


    public Knapsack(int capacity, float granularity, List<Item> items) {
        this.capacity = (int) (capacity / granularity + 1);
        this.items = items;
        rows = items.size() + 1;
        this.granularity = granularity;

        array = new float[rows][(int) ( this.capacity )];
    }

    public Knapsack(int capacity, List<Item> items) {
        this(capacity, 1, items);
    }

    public void fillSolutionArray() {
        float previous;

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[0].length; j++) {
                float weight = j * this.granularity;
                // Find the (i-1,j) value of the array.
                previous = findCell(i - 1, j);
                // Check whether there is still weight available.
                if (items.get(i - 1).getWeight() > weight) {
                    // Copy the previous value into the cell.
                    this.array[i][j] = previous;
                } else if (items.get(i - 1).getWeight() == weight) {
                    this.array[i][j] = Math.max(previous, items.get(i - 1).getValue());
                } else {
                    this.array[i][j] = Math.max(previous, items.get(i - 1).getValue() + this.array[i - 1][((int) (j - items.get(i - 1).getWeight() / this.granularity))]);
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

    public float getGranularity() {
        return this.granularity;
    }

    public static void main(String[] strings) {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Guiter", 1, 1500));
        items.add(new Item("Stereo", 4, 3000));
        items.add(new Item("Laptop", 3, 2000));
        items.add(new Item("I Phone", 1, 2000));
        Knapsack knapsack = new Knapsack(4, items);
        knapsack.fillSolutionArray();
        // 4000 expected
        System.out.println(knapsack.getSolution());

         items = new ArrayList<Item>();
        items.add(new Item("Westminster Abbey", 0.5f, 7));
        items.add(new Item("Globe Theater", 0.5f, 6));
        items.add(new Item("National Gallery", 1, 9));
        items.add(new Item("British Museum", 2, 9));
        items.add(new Item("St Pauls Cathedral", 0.5f, 8));
        knapsack = new Knapsack(2, 0.5f,  items);
        knapsack.fillSolutionArray();
        // 24  expected
        System.out.println(knapsack.getSolution());

        items = new ArrayList<Item>();
        items.add(new Item("Water", 3, 10));
        items.add(new Item("Book", 1, 3));
        items.add(new Item("Food", 2, 9));
        items.add(new Item("Jacket", 2, 5));
        items.add(new Item("Camera", 1, 6));

        knapsack = new Knapsack(6,  items);
        knapsack.fillSolutionArray();
        //   25 expected.
        System.out.println(knapsack.getSolution());

    }
}