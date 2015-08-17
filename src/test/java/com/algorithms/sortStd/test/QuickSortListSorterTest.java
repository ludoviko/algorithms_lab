package com.algorithms.sortStd.test;

import com.algorithms.sortStd.ListSorter;
import com.algorithms.sortStd.QuickSortListSorter;
import com.algorithms.sortStd.SelectionSortListSorter;
import java.util.Comparator;

public class QuickSortListSorterTest extends AbstractListSorterTest {

	@Override
	protected ListSorter createListSorter(
			Comparator comparator) {
		return new QuickSortListSorter(comparator); 
	}



	


}
