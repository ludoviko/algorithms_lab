package com.lam.coursera.princeton.algorithms.sortingWComparator;


public class IntInsertionSortWCompTest  extends IntArraySortAbstractestWComp {
	@Override
	public ArraySortAbstractWComparator<Integer> create() {
		return new InsertionArraySortWComparator<Integer>();
	}
}
