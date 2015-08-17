package com.lam.coursera.princeton.algorithms.sorting;


public class SelectionSortIntegerTest  extends SortAbstractIntegerTest {
	public ArraySortAbstract<Integer> create() {
		return new SelectionArraySort<Integer>();
	}
}
