package com.algorithms.sorting.test;


import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algorithms.list.LinkedList;
import com.algorithms.list.List;
import com.algorithms.sorting.ListSorter_I;
import com.algorithms.sorting.comparator.Comparator;
import com.algorithms.sorting.comparator.NaturalComparator;

public abstract class AbstractListSorterTest extends TestCase {

	private List _unsorted;
	private List _sorted;
	
	protected abstract ListSorter_I createListSorter(Comparator comparator);
	
	@Override
	@Before
	protected void setUp() throws Exception {
		super.setUp();
		
		this._unsorted = new LinkedList();
		this._sorted = new LinkedList();
		
		this._unsorted.add("test");
		this._unsorted.add("driven");
		this._unsorted.add("development");
		this._unsorted.add("is");
		this._unsorted.add("nice");


		this._sorted.add("development");
		this._sorted.add("driven");
		this._sorted.add("is");
		this._sorted.add("nice");
		this._sorted.add("test");
	}

	@Override
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
		this._unsorted = null;
		this._sorted = null;
	}

    @Test(timeout = 2000)
	public void test() {
		ListSorter_I sorter = this.createListSorter(NaturalComparator.INSTANCE);
	    assertEquals(this._sorted, sorter.sort(this._unsorted));		
	}

}
