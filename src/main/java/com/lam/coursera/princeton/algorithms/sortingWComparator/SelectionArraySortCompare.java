package com.lam.coursera.princeton.algorithms.sortingWComparator;


import com.lam.coursera.princeton.algorithms.comparator.NaturalComparator;
import com.lam.coursera.princeton.algorithms.sorting.ArraySortAbstract;

import java.util.Comparator;


// XXX Work in progress
// XXX test missing.
public class SelectionArraySortCompare<T> extends ArraySortAbstractWComparator<T> {

	public SelectionArraySortCompare() {
        this.comparator = NaturalComparator.INSTANCE;
	}

	public T[] sort(T[] array) {
		int minimum = 0;
		
		for (int j = 0; j < array.length - 1; j++) {
			minimum = this.findMinimumIndex(array, j + 1);

			if (this.greater(array[j], array[minimum])) {
				this.swap(array, j, minimum);
			}
		}

		return array;
	}

	public T[] sort(T[] array, Comparator<T> comparator) {
        this.setComparator(comparator);
        return sort(array);
	}
}
