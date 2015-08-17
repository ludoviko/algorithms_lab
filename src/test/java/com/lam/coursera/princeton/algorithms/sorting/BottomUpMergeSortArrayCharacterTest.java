package com.lam.coursera.princeton.algorithms.sorting;


public class BottomUpMergeSortArrayCharacterTest extends SortAbstractCharTest {

	@Override
	public ArraySortAbstract<Character> create() {
		return new BottomUpMergeSortArray<Character>();
	}
}
