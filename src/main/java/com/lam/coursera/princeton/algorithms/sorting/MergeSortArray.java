package com.lam.coursera.princeton.algorithms.sorting;

import java.util.Arrays;

public class MergeSortArray<T> extends ArraySortAbstract<T> {

	public static void merge(Comparable[] a, int low,
			int mid, int hi) {
       
		// assert each half is sorted.
		boolean r =  isSorted(a, low, mid);
		boolean r2 =  isSorted(a, mid+1, hi);
		
		assert isSorted(a, low, mid); // precondition: a[lo..mid] sorted
		assert isSorted(a, mid+1, hi); // precondition: a[mid+1..hi] sorted
		
		Comparable[] aux = Arrays.copyOf(a, a.length);
		
		if (a.length == 1 || a.length == 0) {
			// Nothing to merge
			return;
		} 
		
		//Merge two halves.
		int i, j, d;
		for ( i = low, j = mid + 1, d = low; i <= mid && j <= hi; ) {
			if (less(aux[i],aux[j])) {
				a[d++] = aux[i++];
			} else {
				a[d++] = aux[j++]; 
			}
		}
		
		// What is left in the first half is copied to the destination.
		while ( i <=  mid) {
			a[d++] = aux[i++]; 
		}
		
		// What is left in the second half is copied to the destination.
		while ( j <=  hi) {
			a[d++] = aux[j++]; 
		}
	}

	@Override
	public Comparable<T>[] sort(Comparable<T>[] array) {
		
		this.sort(array,  0, array.length - 1);
		
		return array;
	}

	private void sort(Comparable<T>[] a, int low, int high) {
		if ( low >= high  ) {
			return;
		}
		
		int middle = low  + (high - low) / 2;
		this.sort(a, low, middle);
		this.sort(a,  middle + 1, high);
		merge(a,  low, middle, high);
	}
}
