package com.algorithms.sortStd.test;

import com.algorithms.sortStd.ListSorter;
import com.algorithms.sortStd.MergesortListSorter;

import java.util.Comparator;

public class MergerSortListSorterTest extends AbstractListSorterTest {

	@Override
	protected ListSorter<String> createListSorter(
			Comparator<String> comparator) {
		return new MergesortListSorter<String>(comparator); 
	}



	


}
