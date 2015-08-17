package com.algorithms.search.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

import com.algorithms.search.ListSearcher;
import com.algorithms.sortStd.comparator.NaturalComparator;

public abstract class AbstractListSearchTest extends TestCase {
	private static final String[] VALUES = { "B", "C", "D", "F", "H", "I", "J",
			"K", "L", "M", "P", "Q" };

	private ListSearcher<String>  searcher;
	private List<String> list;

	protected abstract ListSearcher<String>  createSearcher(Comparator<String>  comparator);

	@Before
	public void setUp() throws Exception {
		super.setUp();

		searcher = createSearcher((Comparator<String>) NaturalComparator.INSTANCE);
		list = new ArrayList<String>();

		for (String string : VALUES) {
			list.add(string);
		}
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
		searcher = null;
		list =  null;
	}

	public void testSearchForNonExistingValueLessThanFirstItem() {
		assertEquals(-1, searcher.search(list, "A"));
	}
	public void testSearchForArbitraryNonExistingValue() {
		assertEquals(-4, searcher.search(list, "E"));
	}

	public void testSearchForNonExistingValueGreaterThanLastItem() {
		assertEquals(-13, searcher.search(list, "Z"));
	}

	public void testSearchForExistingValues() {
		for (int i = 0; i < list.size(); ++i) {
			assertEquals(i, searcher.search(list, list.get(i)));
		}
	}
}
