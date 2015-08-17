package com.algorithms.hashing.test;

import org.junit.Test;

import junit.framework.TestCase;

import com.algorithms.hashing.Hashtable;

public abstract class AbstractHashtableTestCase extends TestCase {

	public static final int SIZE = 1000;
	
	private Hashtable table;
	
	protected abstract Hashtable create(int size);
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		table = create(SIZE);
		
		for (int i = 0; i < SIZE; i++) {
			table.add(String.valueOf(i));
		}
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		table = null;
	}

	@Test
	public void testContains() {
		for (int i = 0; i < SIZE; i++) {
			TestCase.assertTrue(table.contains(String.valueOf(i)));
		}
	}

	@Test
	public void testDoesNotContains() {
		for (int i = 0; i < SIZE; i++) {
			TestCase.assertFalse(table.contains(String.valueOf(i + SIZE)));
		}
	}

	@Test
	public void testAddingTheSameObject() {
		TestCase.assertEquals(SIZE, table.size());
		
		for (int i = 0; i < SIZE; i++) {
			table.add(String.valueOf(i));
			TestCase.assertEquals(SIZE, table.size());
		}
	}
}
