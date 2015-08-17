package com.lam.coursera.princeton.algorithms.sorting;

import org.junit.Assert;
import org.junit.Test;

public class MergeSortArrayIntegerTest extends SortAbstractIntegerTest {

	@Override
	public ArraySortAbstract<Integer> create() {
		return new MergeSortArray<Integer>();
	}

	@Test
	public void testMergeSimple() {
		int size = 1;
		this.array = new Integer[size];
		int mid = (this.array.length - 1)/2;
		
		this.array[0] = 0;
		
		MergeSortArray.merge(this.array,  0, mid, size-1);
		
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
	}

	@Test
	public void testMergeSimple_2() {
		int size = 2;

		this.array = new Integer[size];
		int mid = (this.array.length - 1)/2;
		
		for (int i = 0; i < size; i++) {
			this.array[i] = i;
		}
		
		MergeSortArray.merge(this.array,  0, mid, size-1);
		
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
	}

	@Test
	public void testMergeSimple_3() {
		int size = 2;
		
		this.array = new Integer[size];
		int mid = (this.array.length - 1)/2;
		
		this.array[0] = 5;
		this.array[1] = 1;
		
		MergeSortArray.merge(this.array, 0, mid, size-1);
		
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
	}

	@Test
	public void testMergeSimple_4() {
		int size = 3;

		this.array = new Integer[size];
		int mid = (this.array.length - 1)/2;
		
		for (int i = 0; i < size; i++) {
			this.array[i] =  i;
		}
		
		MergeSortArray.merge(this.array, 0, mid, size-1);
		
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
	}
	
	@Test
	public void testMergeSimple_5() {
		int size = 3;
		
		this.array = new Integer[size];
		
		Integer[] solution = new Integer[size];
		solution[0] = 1;
		solution[1] = 3;
		solution[2] = 5;
		
		int mid = (this.array.length - 1)/2;
		
		this.array[0] =  1;
		this.array[1] =  5;
		this.array[2] =  3;
		
		MergeSortArray.merge(this.array, 0, mid, size-1);
		
		Assert.assertArrayEquals(solution,this.array);
	}
	
	@Test
	public void testMergeSimple_6() {
		int size = 4;
		
		this.array = new Integer[size];
		
		Integer[] solution = new Integer[size];
		solution[0] = 1;
		solution[1] = 3;
		solution[2] = 5;
		solution[3] = 7;
		
		int mid = (this.array.length - 1)/2;
		
		this.array[0] =  1;
		this.array[1] =  3;
		this.array[2] =  5;
		this.array[3] =  7;
		
		MergeSortArray.merge(this.array, 0, mid, size-1);
		
		Assert.assertArrayEquals(solution,this.array);
	}

	@Test
	public void testMergeSimple_7() {
		int size = 4;
		
		this.array = new Integer[size];
		
		Integer[] solution = new Integer[size];
		solution[0] = 1;
		solution[1] = 3;
		solution[2] = 5;
		solution[3] = 7;
		
		int mid = (this.array.length - 1)/2;
		
		this.array[0] =  1;
		this.array[1] =  5;
		this.array[2] =  3;
		this.array[3] =  7;
		
		MergeSortArray.merge(this.array, 0, mid, size-1);
		
		Assert.assertArrayEquals(solution,this.array);
	}

	@Test
	public void testMergeSimple_8() {
		int size = 5;
		
		this.array = new Integer[size];
		
		Integer[] solution = new Integer[size];
		solution[0] = 1;
		solution[1] = 7;
		solution[2] = 9;
		solution[3] = 10;
		solution[4] = 11;
		
		int mid = (this.array.length - 1)/2;
		
		this.array[0] =  1;
		this.array[1] =  10;
		this.array[2] =  11;
		this.array[3] =  7;
		this.array[4] =  9;
		
		MergeSortArray.merge(this.array, 0, mid, size-1);
		
		Assert.assertArrayEquals(solution,this.array);
	}
}
