package com.algorithms.array;

public class MergeSortArray<T> {

    public void sort(Comparable<T>[] array) {
        this.sort(array, 0, array.length - 1);
    }

    private void sort(Comparable<T>[] array, int low, int high) {
        if ( low >= high  ) {
            return;
        }

        int middle = (high + low) / 2;
        this.sort(array, low, middle);
        this.sort(array,  middle + 1, high);
        merge(array, low, middle, high);
    }

    /**
     *
     * It merges two subarrays so that the resulting merged array is sorted.
     *
     * @param array: the sourse arrray
     * @param low: the low index of the subarray.
     * @param mid: the middle index of the array, from low to middle is first subarray,
     *           from middle + 1 to high is second one.
     * @param high: the high index of the second subarray.
     */
    public void merge(Comparable<T>[] array, int low, int mid, int high) {
        if (array.length == 1 || array.length == 0) {
            return;
        }

        // Use an auxiliary subarray of length high + 1 - low as a source.
        Comparable<T>[] aux = new Comparable[high + 1 - low];
        System.arraycopy(array, low, aux, 0, high + 1 - low);

        // The modification are written to the main array.
        int i, j, d;
        for ( i = 0,  j = mid + 1 - low, d = low; i <= mid - low  && j <= high - low; ) {
            if ( aux[i].compareTo((T) aux[j]) <= 0  ) {
                array[d++] = aux[i++];
            } else {
                array[d++] = aux[j++];
            }
        }

        while (i <= mid - low ) {
            array[d++] = aux[i++];
        }

        while (j <= high - low ) {
            array[d++] = aux[j++];
        }
    }
}
