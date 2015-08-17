package com.algorithms.sortStd.comparator.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algorithms.sortStd.comparator.CompoundComparator;
import com.algorithms.sortStd.comparator.FixedComparator;
import java.util.Comparator;


import junit.framework.Assert;
import junit.framework.TestCase;

public class CompoundComparatorTest extends TestCase {
	CompoundComparator comparator;

	@Before
	protected void setUp() throws Exception {
		super.setUp();
		comparator = new CompoundComparator();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		comparator = null;
	}

	@Test
	public void testAddComparatorEqual() {
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(0));
		Assert.assertTrue(comparator.compare("IGNORED", "IGNORED") == 0);
	}

	@Test
	public void testAddComparatorLessThan() {
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(-57));
		comparator.add(new FixedComparator(91));
		Assert.assertTrue(comparator.compare("IGNORED", "IGNORED") < 0);
	}

	@Test
	public void testAddComparatorGreaterThan() {
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(0));
		comparator.add(new FixedComparator(91));
		comparator.add(new FixedComparator(-57));
		Assert.assertTrue(comparator.compare("IGNORED", "IGNORED") > 0);
	}
}
