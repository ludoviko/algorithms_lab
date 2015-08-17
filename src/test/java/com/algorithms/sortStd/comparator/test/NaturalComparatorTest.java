package com.algorithms.sortStd.comparator.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algorithms.sorting.comparator.NaturalComparator;

import junit.framework.Assert;
import junit.framework.TestCase;

public class NaturalComparatorTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testLessThan() {
		Assert.assertTrue(NaturalComparator.INSTANCE.compare("A", "B") < 0 );
	}

	@Test
	public void testGreaterThan() {
		Assert.assertTrue(NaturalComparator.INSTANCE.compare("C", "B") > 0 );
	}
	
	@Test
	public void testEquals() {
		Assert.assertTrue(NaturalComparator.INSTANCE.compare("A", "A") == 0 );
	}

}
