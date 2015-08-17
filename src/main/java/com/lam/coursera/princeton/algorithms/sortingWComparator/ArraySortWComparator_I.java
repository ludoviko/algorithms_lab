package com.lam.coursera.princeton.algorithms.sortingWComparator;

import java.util.Comparator;

public interface ArraySortWComparator_I<T> {

	public T[] sort(T[] array, Comparator<T> comparator) ;
	public T[] sort(T[] array) ;

}
