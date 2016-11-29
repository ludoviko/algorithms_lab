package com.algorithms.array;

public class InsertionSortArray<T> {
    Comparable<T>[] data;

    public void sort(Comparable<T>[] array) {

        Comparable<T> value;
        for (int i = 1; i < array.length; i++) {
            // Take a value one position to the left of zero.
            value = array[i];
            for (int j = 0; j < i; j++) {
                // Compare the value with the sorted array of size j.
                if ( value.compareTo((T) array[j]) >= 1 ) {
                    // Move the pointer on to the right.
                } else {
                    // Move the array from j to i -1 one position to the right.
                    System.arraycopy(array, j, array, j + 1, i - j );
                    // Copy the value into the new spot at array[j] and break loop.
                    array[j] = value;
                    break;
                }
            }
        }
    }

}
