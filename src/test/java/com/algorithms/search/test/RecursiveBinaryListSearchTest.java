package com.algorithms.search.test;


import java.util.Comparator;

import org.junit.After;
import org.junit.Before;

import com.algorithms.search.ListSearcher;
import com.algorithms.search.RecursiveBinaryListSearch;

public class RecursiveBinaryListSearchTest extends AbstractListSearchTest {
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Override
	protected ListSearcher<String> createSearcher(Comparator<String> comparator) {
		return new RecursiveBinaryListSearch<String>(comparator);
	}
}
