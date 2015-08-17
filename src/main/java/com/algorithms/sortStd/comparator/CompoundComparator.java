package com.algorithms.sortStd.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class CompoundComparator  implements Comparator<Object> {

    private List<Comparator> comparators = new ArrayList<Comparator>();
	
	public void add (Comparator comparator) {
		this.comparators.add(comparator);
	}
	
	
	public int compare(Object o1, Object o2) {
		
		int result = 0;
		
		Iterator<Comparator> iterator = this.comparators.iterator();
		
        while (iterator.hasNext()) {
        	result = iterator.next().compare(o1, o2);
        	if (result != 0) {
        		break;
        	}
        }
		
		return result;
	}



}
