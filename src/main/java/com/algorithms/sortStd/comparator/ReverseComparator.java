package com.algorithms.sortStd.comparator;

import java.util.Comparator;

public class ReverseComparator implements Comparator {

	private final Comparator _comparator;
	
    public ReverseComparator(NaturalComparator comparator) {
    	this._comparator = comparator;
    }

	public int compare(Object left, Object right) throws ClassCastException {
		return this._comparator.compare(right, left);
	}

}
