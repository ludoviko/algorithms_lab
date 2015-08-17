package com.algorithms.sortStd.test;

import com.algorithms.sortStd.ListSorter;
import com.algorithms.sortStd.SelectionSortListSorter;
import java.util.Comparator;

public class SelectionSortListSorterTest extends AbstractListSorterTest {

	@Override
	protected ListSorter createListSorter(
			Comparator comparator) {
		return new SelectionSortListSorter(comparator); 
	}



	


}
