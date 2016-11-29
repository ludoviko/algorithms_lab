package com.algorithms.search;

import java.util.Comparator;

import org.junit.After;
import org.junit.Before;

public class IterativeBinaryListSearcherTest extends AbstractListSearchTest {

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
		return new IterativeBinaryListSearcher<String>(comparator);
	}
}
