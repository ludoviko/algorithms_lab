package com.lam.coursera.princeton.algorithms.sorting;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class SortAbstractCharTest {
	ArraySortAbstract<Character> sort;
	Character[] array;

	public abstract ArraySortAbstract<Character> create();

	@Before
	public void setUp() throws Exception {
		this.array = new Character[1];
		this.array[0] = 'a';
		this.sort = this.create();
	}

	@After
	public void tearDown() throws Exception {
		this.array = null;
		this.sort = null;
	}

	@Test
	public void testSortOneElementArray() {
		this.array = new Character[1];
		this.array[0] = 'b';
		this.sort.sort(this.array);
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
	}

	@Test
	public void testSortTwoElementArray() {
		int size = 2;
		this.array = new Character[size];

		this.array[0] = 'b';
		this.array[1] = 'a';

		this.sort.sort(this.array);
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
	}

	@Test
	public void testSortThreeElementArray() {
		int size = 3;
		this.array = new Character[size];

		this.array[0] = 'c';
		this.array[1] = 'b';
		this.array[2] = 'a';

		Character[] solution = {'a', 'b', 'c'}; 
		
		this.sort.sort(this.array);
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
		Assert.assertArrayEquals(solution, this.array);
	}

	@Test
	public void testSortFourElementArray() {
		int size = 4;
		this.array = new Character[size];

		this.array[0] = 'd';
		this.array[1] = 'c';
		this.array[2] = 'b';
		this.array[3] = 'a';

		this.sort.sort(this.array);
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
	}

	@Test
	public void testSortFiveElementArray() {
		int size = 5;
		
		Character[] solution = {'a', 'b', 'c', 'd', 'e'}; 
		
		this.array = new Character[size];

		this.array[0] = 'e';
		this.array[1] = 'd';
		this.array[2] = 'c';
		this.array[3] = 'b';
		this.array[4] = 'a';
		
		this.sort.sort(this.array);
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
		Assert.assertArrayEquals(solution, this.array);
	}

	@Test
	public void testAny() {
		Character[] solution = {'a', 'e','e','e','e', 'g', 'l', 'm','m','o','p','r','r','s','t','x'}; 
		String data = "mergesortexample";
		this.array = new Character[data.length()];
		
		
		for (int i = 0; i < data.length(); i++) {
			this.array[i] = data.charAt(i);	
		}
		
		this.sort.sort(this.array);
		Assert.assertTrue(ArraySortAbstract.isSorted(this.array));
		Assert.assertArrayEquals(solution, this.array);
	}

}
