package com.lam.coursera.princeton.algorithms.sorting;


public class MergeSortArrayCharacterTest extends SortAbstractCharTest {

	@Override
	public ArraySortAbstract<Character> create() {
		return new MergeSortArray<Character>();
	}
}
