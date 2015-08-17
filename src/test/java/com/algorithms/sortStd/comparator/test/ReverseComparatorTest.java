package com.algorithms.sortStd.comparator.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algorithms.sorting.comparator.NaturalComparator;
import com.algorithms.sorting.comparator.ReverseComparator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ReverseComparatorTest extends TestCase {

	ReverseComparator reverse;
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		reverse = new ReverseComparator(NaturalComparator.INSTANCE);
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		reverse = null;
	}

	@Test
	public void testLessThanBecomesGreaterThan() {
		Assert.assertTrue(reverse.compare("A", "B") > 0 );
	}

	@Test
	public void testGreaterThanBecomesLessThan() {
		Assert.assertTrue(reverse.compare("B", "A") < 0 );
	}
	
	@Test
	public void testEquals() {
		Assert.assertTrue(reverse.compare("A", "A") == 0 );
	}

}
