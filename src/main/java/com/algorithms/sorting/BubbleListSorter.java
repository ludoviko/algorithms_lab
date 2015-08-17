package com.algorithms.sorting;

import com.algorithms.list.List;
import com.algorithms.sorting.comparator.Comparator;

public class BubbleListSorter implements ListSorter {

	private Comparator comparator;
	
	public BubbleListSorter(Comparator comparator) {
		this.comparator = comparator;
	}
	

	public List sort(List list) {
		Object temp;
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				if ( this.comparator.compare(list.getAt(j+1), list.getAt(j))  < 0) {
					temp = list.getAt(j);
					list.setAt(j, list.getAt(j+1));
					list.setAt(j+1, temp);
				}
			}
		}
		
		return list;
	}

}
