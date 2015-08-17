package com.lam.coursera.princeton.algorithms.sorting;


public class SelectionArraySort<T> extends ArraySortAbstract<T> {
	
	@Override
	public Comparable<T>[] sort(Comparable<T>[] array) {
		int minimum = 0;
		
		for (int j = 0; j < array.length - 1; j++) {
			minimum = ArraySortAbstract.findMinimumIndex(array, j + 1);

			if (ArraySortAbstract.greater(array[j], array[minimum])) {
				ArraySortAbstract.swap(array, j, minimum);
			}
		}

		return array;
	}
}
