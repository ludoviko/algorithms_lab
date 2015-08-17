package com.lam.coursera.princeton.algorithms.sorting;

public class InsertionArraySort<T> extends ArraySortAbstract<T> {

	@Override
	public Comparable<T>[] sort(Comparable<T>[] array) {
		int step = 1;
		
		for (int j = 1; j < array.length; j++) {
			transverseToTheLeft(array, j, step);
		}

		return array;
	}
	
}
