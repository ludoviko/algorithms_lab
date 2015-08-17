package com.algorithms.tree;

import com.algorithms.sorting.comparator.Comparator;

public class BinarySearchTreeOld<T> {

	private final Comparator comparator;
	private Node<T> root;
	
	public BinarySearchTreeOld(Comparator comparator) {
		this.comparator = comparator;
	};
	
	public Node<T> getRoot() {
		return this.root;
	}
	
	public Node<T> search(Object data) {
		assert data != null : "Data can not be null";
		
		Node<T> node = root;
		
		while (node != null) {
		    int compare = this.comparator.compare(data, node.getValue());
		    if ( compare == 0 ) {
		    	break;
		    }
		    node = compare < 0 ? node.getSmaller() : node.getLarger();
		};
		
		return node;
	}
	

	  /**
     * Insert a value in the tree.
     *
     * @param value The value to insert.
     * @return The inserted node.
     */
    public Node<T> insert(T data) {
        Node<T> parent = null;
        Node<T> node = root;
        int cmp = 0;

        while (node != null) {
            parent = node;
            cmp = this.comparator.compare(data, node.getValue());
            node = cmp <= 0 ? node.getSmaller() : node.getLarger();
        }

        Node<T> inserted = new Node<T>(data);
        inserted.setParent(parent);

        if (parent == null) {
            root = inserted;
        } else if (cmp < 0) {
            parent.setSmaller(inserted);
        } else {
            parent.setLarger(inserted);
        }

        return inserted;
    }

    /**
     * Deletes a value from the tree.
     *
     * @param value The value to delete.
     * @return The deleted node; or <code>null</code> if not found.
     */
    public Node<T> delete(T data) {
        Node<T> node = search(data);
        if (node == null) {
            return null;
        }

        Node<T> deleted = node.getSmaller() != null && node.getLarger() != null ? node.successor() : node;
        assert deleted != null : "deleted can't be null";

        Node<T> replacement = deleted.getSmaller() != null ? deleted.getSmaller() : deleted.getLarger();
        if (replacement != null) {
            replacement.setParent(deleted.getParent());
        }

        if (deleted == root) {
            root = replacement;
        } else if (deleted.isSmaller()) {
            deleted.getParent().setSmaller(replacement);
        } else {
            deleted.getParent().setLarger(replacement);
        }

        if (deleted != node) {
            T deletedValue = node.getValue();
            node.setValue(deleted.getValue());
            deleted.setValue(deletedValue);
        }

        return deleted;
    }
	
}
