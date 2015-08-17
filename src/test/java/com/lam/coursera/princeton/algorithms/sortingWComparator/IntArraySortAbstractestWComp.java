package com.lam.coursera.princeton.algorithms.sortingWComparator;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class IntArraySortAbstractestWComp {
	ArraySortAbstractWComparator<Integer> sort;
	Integer[] array;

	public abstract ArraySortAbstractWComparator<Integer> create();

	@Before
	public void setUp() throws Exception {
		this.array = new Integer[1];
		this.array[0] = 1;
		this.sort = this.create();
	}

	@After
	public void tearDown() throws Exception {
		this.array = null;
		this.sort = null;
	}

	@Test
	public void testSortOneElementArray() {
		this.array = new Integer[1];
		this.array[0] = 1;
		this.sort.sort(this.array);
		Assert.assertTrue(this.sort.isSorted(this.array));
	}

	@Test
	public void testSortTwoElementArray() {
		int size = 2;
		this.array = new Integer[size];

		for (int i = 0; i < size; i++) {
			this.array[i] = size - 1 - i;
		}

		this.sort.sort(this.array);
		Assert.assertTrue(this.sort.isSorted(this.array));
	}

	@Test
	public void testSortThreeElementArray() {
		int size = 3;
		this.array = new Integer[size];

		for (int i = 0; i < size; i++) {
			this.array[i] = size - 1 - i;
		}

		Integer[] solution = {0, 1, 2}; 
		
		this.sort.sort(this.array);
		Assert.assertTrue(this.sort.isSorted(this.array));
		Assert.assertArrayEquals(solution, this.array);
	}

	@Test
	public void testSortFourElementArray() {
		int size = 4;
		this.array = new Integer[size];

		for (int i = 0; i < size; i++) {
			this.array[i] = size - 1 - i;
		}

		this.sort.sort(this.array);
		Assert.assertTrue(this.sort.isSorted(this.array));
	}

	@Test
	public void testSortFiveElementArray() {
		int size = 5;
		
		Integer[] solution = {0, 1, 2, 3, 4}; 
		
		this.array = new Integer[size];

		this.array[0] = 4;
		this.array[1] = 1;
		this.array[2] = 0;
		this.array[3] = 3;
		this.array[4] = 2;
		
		this.sort.sort(this.array);
		Assert.assertTrue(this.sort.isSorted(this.array));
		Assert.assertArrayEquals(solution, this.array);
	}

	@Test
	public void testFindMimimum() {
		int size = 10;
		this.array = new Integer[size];

		for (int i = 0; i < size; i++) {
			this.array[i] = size - 1 - i;
		}

		int minimum = this.sort.findMinimumIndex(this.array, 0);
		Assert.assertEquals(minimum, 9);
	}

	@Test
	public void testFindMimimum2() {
		int size = 5;
		this.array = new Integer[size];

		this.array[0] = 0;
		this.array[1] = 2;
		this.array[2] = 3;
		this.array[3] = 4;
		this.array[4] = 10;

		int minimum = this.sort.findMinimumIndex(this.array, 1);
		Assert.assertEquals(minimum, 1);

		minimum = this.sort.findMinimumIndex(this.array, 2);
		Assert.assertEquals(minimum, 2);
	}

//	@Ignore
	@Test
	public void testSortArrayAnySize() {
		int size = 100;

		Random randomGenerator = new Random();

		this.array = new Integer[size];

		for (int i = 0; i < size; i++) {
			this.array[i] = randomGenerator.nextInt(100);
		}

		Integer[] solution = Arrays.copyOf(this.array, size);
		
		Arrays.sort(solution);
		
		this.sort.sort(this.array);
		Assert.assertTrue(this.sort.isSorted(this.array));
		Assert.assertArrayEquals(solution, this.array);
	}
}
