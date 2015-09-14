package com.lam.coursera.princeton.algorithms.sortingWComparator;

public class SelectionSortIntegerWCompTest extends IntArraySortAbstractestWComp {
	public ArraySortAbstractWComparator<Integer> create() {
		return new SelectionArraySortWComparator<Integer>();
	}
}
