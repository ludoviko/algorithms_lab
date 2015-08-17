package com.lam.coursera.princeton.algorithms.sorting;


public abstract class ArraySortAbstract<T> implements ArraySort_I<T> {
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if ( less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSorted(Comparable[] a, int from, int to) {
		for (int i = from + 1; i <= to; i++) {
			if ( less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public static int findMinimumIndex(Comparable[] array, int from) {
		int minimum = from;

		for (int i = from; i < array.length; i++) {
			if (less(array[i], array[minimum])) {
				minimum = i;
			} else {
			}
		}
		return minimum;
	}
	
	protected static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	protected static boolean greater(Comparable a, Comparable b) {
		return a.compareTo(b) > 0;
	}

	protected static void swap(Comparable[] array, int i, int j) {
		if (i == j) {
			return;
		}
		
		Comparable aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}
	
	protected static void transverseToTheLeft(Comparable[] array, int from, int step) {
		for (int i = from; i > 0; i = i - step) {
			if (less(array[i], array[i-step])) {
				swap(array, i, i-step);
			} else {
				break;
			}
		}
	}

}
