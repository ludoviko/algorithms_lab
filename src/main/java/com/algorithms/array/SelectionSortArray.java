package com.algorithms.array;

public class SelectionSortArray<T> {
    Comparable<T>[] data;

    public void sort(Comparable<T>[] array) {

        int indexMinimun = -1;

        for (int i = 0; i < array.length; i++) {
//        Find the smallest card in the array of size n-1. Swap it with the first card.
//        Find the second-smallest card in the array of size n-2. Swap it with the second card.
//        Find the third-smallest card in the array of size n-3. Swap it with the third card.
//        Repeat finding the next-smallest card, and swapping it into the correct position until the array is sorted.
            indexMinimun = this.minimum(array, i);
            this.swap(array, i, indexMinimun);
        }
    }

    public void swap(Comparable<T>[] array, int a, int b) {
        Comparable<T> t =  array[a];
        array[a] = array[b];
        array[b] = (Comparable<T>) t;
    }

    public int minimum(Comparable<T>[] array, int from) {
        int minimumIndex = from;

        for (int i = from + 1; i < array.length ; i++) {
            if ( array[i].compareTo((T) array[minimumIndex]) < 0  ) {
                minimumIndex = i;
            } else {
            }
        }

        return minimumIndex;
    }
}
