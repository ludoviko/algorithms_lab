package com.algorithms.sortStd.comparator;

import java.util.Comparator;

public class FixedComparator  implements Comparator<Object> {

	private int result;
	
	public  FixedComparator(int result) {
		this.result = result;
	}
	
	public int compare(Object o1, Object o2) {
		return this.result;
	}

}
