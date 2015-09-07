package com.lam.coursera.princeton.algorithms.sortingWComparator;

import java.util.Comparator;

import com.lam.coursera.princeton.algorithms.comparator.NaturalComparator;

public class InsertionArraySortWComparator<T> extends ArraySortAbstractWComparator<T> {

	public InsertionArraySortWComparator() { 
	    this.comparator = NaturalComparator.INSTANCE;
	}
	
	public T[] sort(T[] array, Comparator<T> comparator) {
		int step = 1;
		
		this.comparator = comparator;
		
		for (int j = 1; j < array.length; j++) {
			this.transverseToTheLeft(array, j, step);
		}

		return array;
	}

	public T[] sort(T[] array) {
		int step = 1;
		
		for (int j = 1; j < array.length; j++) {
			this.transverseToTheLeft(array, j, step);
		}

		return array;
	}

	public void transverseToTheLeft(T[] array, int from, int step) {
		for (int i = from; i > 0; i = i - step) {
			if (this.less(array[i], array[i-step])) {
				this.swap(array, i, i-step);
			} else {
				break;
			}
		}
	}
}
