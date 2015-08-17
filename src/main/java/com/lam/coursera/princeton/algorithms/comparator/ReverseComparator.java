package com.lam.coursera.princeton.algorithms.comparator;

import java.util.Comparator;

public class ReverseComparator<T> implements Comparator<T> {

	private final Comparator<T> comparator;
	
    public ReverseComparator(NaturalComparator<T> comparator) {
    	this.comparator = comparator;
    }

    public int compare(T left, T right) throws ClassCastException {
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";
		return this.comparator.compare(right, left);
	}

}
