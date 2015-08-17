package com.lam.coursera.princeton.algorithms.sorting;

public class BottomUpMergeSortArray<T> extends MergeSortArray<T> {

	@Override
	public Comparable<T>[] sort(Comparable<T>[] array) {

		// Basic plan.
		// Pass through array, merging subarrays of size 1.
		// Repeat for subarrays of size 2, 4, 8, 16, ....

		int middle, high;

		for (int size = 1; size <= array.length; size *= 2) {
			for (int low = 0; low < array.length - size; low += size * 2) {

				high =  (low + 2 * size - 1);
				middle = low + (size - 1);
				
				if ( high > array.length - 1) {
					high = array.length - 1;
				} else {
				}

				merge(array, low, middle, high);
			}
		}

		return array;
	}

}
