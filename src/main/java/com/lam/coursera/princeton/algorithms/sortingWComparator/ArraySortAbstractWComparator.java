package com.lam.coursera.princeton.algorithms.sortingWComparator;

import java.util.Comparator;
// Comment.
public abstract class ArraySortAbstractWComparator<T> implements ArraySortWComparator_I<T> {
	
	protected Comparator<T> comparator;
	
	public  boolean isSorted(T[] a) {
		for (int i = 1; i < a.length; i++) {
			if ( this.less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public  boolean isSorted(T[] a, int from, int to) {
		for (int i = from + 1; i <= to; i++) {
			if ( this.less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public int findMinimumIndex(T[] array, int from) {
		int minimum = from;

		for (int i = from; i < array.length; i++) {
			if (this.less(array[i], array[minimum])) {
				minimum = i;
			} else {
			}
		}
		return minimum;
	}
	
	protected  boolean less(T a, T b) {
		return this.comparator.compare(a, b) < 0;
	}

	protected boolean greater(T a, T b) {
		return this.comparator.compare(a, b) > 0;
	}

	protected void swap(T[] array, int i, int j) {
		if (i == j) {
			return;
		}
		
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
}
