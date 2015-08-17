package com.lam.coursera.princeton.algorithms.bag;

import java.util.Iterator;

import com.lam.coursera.princeton.algorithms.Node;

public class LinkedBag<T> implements Bag_I<T> {
	private int size;
	private Node<T> first;

	public LinkedBag() {
		this.size = 0;
	}

	@Override
	public Iterator<T> iterator() {

		return new Iterator<T>() {
			private Node<T> current = LinkedBag.this.first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException(
						"Operation not supported.");
			}

			@Override
			public T next() {
				T t = current.getType();
				
				current = current.getNext();
				
				return t;
			}
		};
	}

	@Override
	public void add(T t) {
		Node<T> node = new Node<T>(t);
		node.setNext(this.first);
		this.first = node;
		this.size++;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	public String toString() {
		return null;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.first = new Node<T>();
	}
}
