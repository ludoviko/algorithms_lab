package com.algorithms.tree2.imp;


import com.algorithms.tree2.ITree;

public class NonEmptyBST<T extends Comparable> implements ITree<T> {
    private T t;
    private ITree left;
    private ITree right;

    public NonEmptyBST(T t) {
        this.t = t;
        this.left = new EmptyBST<T>();
        this.right  = new EmptyBST<T>();
    }

    public NonEmptyBST(T t, ITree<T> leftTree, ITree rightTree) {
        this.t = t;
        this.left = leftTree;
        this.right = rightTree;
    }

    public boolean isEmpty() {
        return false;
    }

    public int cardinality() {
        return 1 + this.left.cardinality() + this.right.cardinality();
    }

    public boolean isMember(T e) {
        if (this.t == t) {
            return true;
        } else {
            if (e.compareTo(t) < 0) {
                return this.left.isMember(e);
            } else {
                return this.right.isMember(e);
            }
        }
    }

    public NonEmptyBST<T> add(T e) {
        if (this.t == e) {
            return this;
        } else {
            if (e.compareTo(t) < 0) {
                return new NonEmptyBST<T>(t, this.left.add(e), this.right );
            } else {
                return new NonEmptyBST<T>(t, this.left, this.right.add(e) );
            }
        }
    }
}
