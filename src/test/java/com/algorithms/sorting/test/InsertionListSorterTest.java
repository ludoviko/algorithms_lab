package com.algorithms.sorting.test;

import com.algorithms.sorting.BubbleListSorter;
import com.algorithms.sorting.ListSorter;
import com.algorithms.sorting.comparator.Comparator;

/**
 */
public class InsertionListSorterTest extends AbstractListSorterTest {
	
	@Override
	protected ListSorter createListSorter(Comparator comparator) {
        return new BubbleListSorter(comparator);
	}
}
