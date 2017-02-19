package com.algorithms.tree2;

import com.algorithms.tree2.imp.NonEmptyBST;

/**
 * Created by Usuario on 23/09/2016.
 */
public interface ITree<T extends Comparable> {
    public boolean isEmpty();
    public int cardinality();
    public boolean isMember(T t);
    public NonEmptyBST<T> add(T t);
}
