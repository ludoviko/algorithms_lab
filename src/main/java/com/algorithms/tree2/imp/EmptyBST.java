package com.algorithms.tree2.imp;

import com.algorithms.tree2.ITree;

/**
 * Created by Usuario on 23/09/2016.
 */
public class EmptyBST<T extends Comparable> implements ITree<T> {

    public EmptyBST() {
    }

    public boolean isEmpty() {
        return true;
    }

    public int cardinality() {
        return 0;
    }

    public boolean isMember(T t) {
        return false;
    }

    public NonEmptyBST<T> add(T t) {
        return new NonEmptyBST<T>(t);
    }
}
