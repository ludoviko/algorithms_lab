package com.lam.coursera.princeton.algorithms.sorting;

public class ShellArraySort<T> extends ArraySortAbstract<T> {

	@Override
	public Comparable<T>[] sort(Comparable<T>[] array) {

		int step = 1;
		while (step < array.length) {
			// 1, 4, 13, 40, 121, 364, ...
			step = 3 * step + 1; 
		}
		
		while (step >= 1) { 
			// h-sort the array.
			for (int j = step; j < array.length; j = j + step) {
				transverseToTheLeft( array, j, step);
			}
			step = step / 3;
		}

		return array;
	}
	
//	@SuppressWarnings("rawtypes")
//	public static void transverseToTheLeft(Comparable[] array, int from, int step) {
//		
//		for (int i = from; i > 0; i = i - step) {
//			if (less(array[i], array[i-step])) {
//				swap(array, i, i-step);
//			} else {
//				break;
//			}
//		}
//	}
}
	

