package com.algorithms.sortStd.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;
import com.algorithms.sortStd.ListSorter;
import java.util.Comparator;
import com.algorithms.sortStd.comparator.NaturalComparator;

import junit.framework.TestCase;

public abstract class AbstractListSorterTest extends TestCase {
	private List<String> _unsorted;
	private List<String> _sorted;
	
	protected abstract ListSorter<String> createListSorter(Comparator<String> comparator);
	
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
		_unsorted = new ArrayList<String>();
		_sorted = new ArrayList<String>();
		
		_unsorted.add("very");
		_unsorted.add("test");
		_unsorted.add("driven");
		_unsorted.add("development");
		_unsorted.add("is");
		_unsorted.add("nice");

		_sorted.add("development");
		_sorted.add("driven");
		_sorted.add("is");
		_sorted.add("nice");
		_sorted.add("test");
		_sorted.add("very");
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		_unsorted = null;
		_sorted = null;
	}

	@Test
	public void test() {
		ListSorter<String> sorter = createListSorter( (Comparator<String>) NaturalComparator.INSTANCE);
	    assertEquals(_sorted, sorter.sort(_unsorted));		
	}

}
