package com.lam.coursera.princeton.algorithms.sorting;


public class ShellSortIntegerTest  extends SortAbstractIntegerTest {
	@Override
	public ArraySortAbstract<Integer> create() {
		return new ShellArraySort<Integer>();
	}
}
