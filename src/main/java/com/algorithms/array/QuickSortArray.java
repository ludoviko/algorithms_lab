package com.algorithms.array;

public class QuickSortArray<T> {

    public void sort(Comparable<T>[] array) {
        // Shuffle the source array.
        // Once copied into library call the helper shuffle class.
        this.sort(array, 0, array.length - 1);
    }

    public void sort(Comparable<T>[] array, int low, int high) {
        if ( high <=  low ) {
            return;
        }

        int j = partition(array, low, high);

        this.sort(array, low,  j - 1);
        this.sort(array, j + 1, high);
    }

    /**
     * @param array: the target array.
     * @param low: the index of the starting partition value, the pivot.
     * @param high: the highest element in the array.
     * @return the partition index.
     */
    public int  partition(Comparable<T>[] array, int low, int high) {
        // low: could be zero.
        int i = low + 1;
        int j = high;

        while (true) {
            while ( i < high && array[i].compareTo((T) array[low]) < 0 ) {
                i++;
            }

            while ( j > low && array[j].compareTo((T) array[low]) > 0 ) {
                j--;
            }

            if ( i >= j ) {
                break;
            }

            swap(array, i, j);
        }

        swap(array, j, low);
        return j;
    }

    public void swap(Comparable<T>[] array, int a, int b) {
        Comparable<T> t =  array[a];
        array[a] = array[b];
        array[b] = (Comparable<T>) t;
    }
}
