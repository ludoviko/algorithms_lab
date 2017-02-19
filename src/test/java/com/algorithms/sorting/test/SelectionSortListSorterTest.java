package com.algorithms.sorting.test;

import org.junit.Ignore;

import com.algorithms.sorting.ListSorter_I;
import com.algorithms.sorting.SelectionSortListSorter;
import com.algorithms.sorting.comparator.Comparator;

@Ignore	
public class SelectionSortListSorterTest extends AbstractListSorterTest {


	@Override
	@Ignore	
	protected ListSorter_I createListSorter(Comparator comparator) {
		return new SelectionSortListSorter(comparator); 
	}

}
