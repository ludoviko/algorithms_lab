package com.algorithms.tree;

import java.util.Comparator;

// An unbalanced tree
public class BinarySearchTree<T> {
	private final Comparator<T> comparator;
	private Node<T> root;

	public BinarySearchTree(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public Node<T> getRoot() {
		return this.root;
	}

	public Node<T> search(T key) {
		Node<T> node = root;

		while (node != null) {
			if ((comparator.compare(key, node.getValue()) < 0)) {
				node = node.getSmaller();
			} else if (comparator.compare(key, node.getValue()) > 0) {
				node = node.getLarger();
			} else {
				break;
			}
		}
		return node;
	}

	public Node<T> insert(T key) {
		Node<T> parent = null;
		Node<T> node = root;
		int cmp = 0;

		while (node != null) {
			parent = node;
			cmp = this.comparator.compare(key, node.getValue());
			node = cmp < 0 ? node.getSmaller() : node.getLarger();
		}

		Node<T> inserted = new Node<T>(key);
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

	public Node<T> insertNew(T key) {
		return null;
	}
	
	public Node<T> delete(T key) {
		Node<T> searchedFor = search(key);
		Node<T> parent = searchedFor.getParent();
		Node<T> child;
		
		if (searchedFor.isLeaf()) {
			if (searchedFor.isLarger()) {
				parent.setLarger(null);
			} else if (searchedFor.isSmaller()) {
				parent.setSmaller(null);
			}
		} else {
			// how many children ? 
			if ( searchedFor.getLarger() != null ^ searchedFor.getSmaller() != null) {
				child = searchedFor.getLarger() != null ? searchedFor.getLarger() : searchedFor.getSmaller();
				child.setParent(parent);
				if ( searchedFor.getLarger() != null ) {
					parent.setLarger(child);
				} else {
					parent.setSmaller(child);
				}
			} else {
				// Two children...  	
				Node<T> sucTmp = searchedFor.successor();
				Node<T> successor = searchedFor.successor();
				successor.getParent().setParent(successor);
				successor.getParent().setParent(successor);
				successor.setSmaller(searchedFor.getSmaller()); 
				successor.setLarger(searchedFor.getLarger());
				successor.setParent(null);
				if (root == searchedFor) {
					root = successor; 
				}
				searchedFor.setSmaller(null);
				searchedFor.setLarger(null);
				searchedFor.setParent(null);
			}
		}
		return searchedFor;
	}

    public Node<T> delete2(T data) {
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
