package com.lam.coursera.princeton.algorithms.sorting;


public class InsertionSortIntegerTest  extends SortAbstractIntegerTest {
	public ArraySortAbstract<Integer> create() {
		return new InsertionArraySort<Integer>();
	}
}
