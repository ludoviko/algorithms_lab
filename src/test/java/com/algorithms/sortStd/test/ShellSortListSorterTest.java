package com.algorithms.sortStd.test;

import java.util.Comparator;

import com.algorithms.sortStd.ListSorter;
import com.algorithms.sortStd.MergesortListSorter;

public class ShellSortListSorterTest extends AbstractListSorterTest {

	@Override
	protected ListSorter createListSorter(
			Comparator comparator) {
		return new MergesortListSorter(comparator); 
	}



	


}
