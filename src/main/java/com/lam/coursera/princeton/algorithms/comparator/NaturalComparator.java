package com.lam.coursera.princeton.algorithms.comparator;

import java.util.Comparator;

/**
 * A {@link Comparator} that compares objects that have a natural sort order, ie. implement {@link Comparable}.
 *
 */
public final class NaturalComparator<T> implements Comparator<T> {
    /** The single, publicly accessible, instance of the comparator. */
    public static final NaturalComparator INSTANCE = new NaturalComparator();

    /**
     * Constructor marked private to prevent instantiation.
     */
    private NaturalComparator() {
    }

    @Override
	public int compare(T left, T right) throws ClassCastException {
        assert left != null : "left can't be null";
        assert right != null : "right can't be null";

        // T is of class Comparable ! 
        return  ((Comparable<T>) left).compareTo(right);
    }
}
