package com.algorithms.sorting;

import com.algorithms.list.List;
import com.algorithms.sorting.comparator.Comparator;

public class SelectionSortListSorter implements ListSorter_I {

	private Comparator comparator;
	
	public SelectionSortListSorter(Comparator comparator) {
		this.comparator = comparator;
	}

	// XXX
	
	public List sort(List list) {
		Object temp;
		
		int index = 0;
		
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size() ; j++) {
				if ( this.comparator.compare(list.getAt(j), list.getAt(i)) < 0) {
					index = j;
				} else {
					index = j;
				}
			}
			temp = list.getAt(index);
			list.setAt(index, list.getAt(i));
			list.setAt(i, temp);
		}
		
		return list;
	}

}
