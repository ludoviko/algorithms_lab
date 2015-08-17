package com.algorithms.sortStd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SelectionSortListSorter implements ListSorter<Object> {

	private Comparator<Object> comparator;
	
	public SelectionSortListSorter(Comparator<Object> comparator) {
		this.comparator = comparator;
	}

	public List<Object> sort(List<Object> list) {
		Object object;

		List<Object> sorted = new ArrayList<Object>();
		
		Iterator<Object> itera  = list.iterator();
		
		while(itera.hasNext()) {
			object = itera.next();
			int index = sorted.size();
			
	        while ( index > 0 ) {
				if (this.comparator.compare(object, sorted.get(index-1)) >= 0) {
					break;
				}
				index--; 
	        }
			sorted.add(index, object);
		} 
		return sorted;
	}

}
