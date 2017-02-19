package com.algorithms.sorting.test;

import com.algorithms.sorting.InsertionSortListSorter;
import com.algorithms.sorting.ListSorter_I;
import com.algorithms.sorting.comparator.Comparator;

/**
 */
public class InsertionListSorterTest extends AbstractListSorterTest {
	
	@Override
	protected ListSorter_I createListSorter(Comparator comparator) {
        return new InsertionSortListSorter(comparator);
	}
}
