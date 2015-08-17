package com.lam.coursera.princeton.algorithms.stack;

import java.util.Iterator;

import com.lam.coursera.princeton.algorithms.Node;
import com.lam.coursera.princeton.algorithms.exception.EmptyStackException;

public class LinkedStack<T> implements Stack_I<T>, Iterable<T> {
	private Node<T> first;
	private int size;

	public LinkedStack() {
		this.size = 0;
	}

	@Override
	public void push(T t) {
		Node<T> node = new Node<T>(t);
		node.setNext(this.first);
		this.first = node;
		this.size++;
	}

	@Override
	public T pop() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException("The stack is empty.");
		}
		T t = this.first.getType();

		Node<T> old = this.first;

		this.first = this.first.getNext();

		old.clear();
		this.size--;
		return t;
	}

	@Override
	public T peek() throws EmptyStackException {
		if (this.isEmpty()) {
			throw new EmptyStackException("The stack is empty.");
		}
		return this.first.getType();
	}

	@Override
	public void clear() {
		this.first = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		Node<T> node = this.first;

		while (node.getNext() != null) {
			builder.append(node.toString() + " ");
			node = node.getNext();
		}

		return builder.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Node<T> current = LinkedStack.this.first;

			@Override
			public boolean hasNext() {
				return this.current != null;
			}

			@Override
			public T next() {
				T t = this.current.getType();

				this.current = this.current.getNext();

				return t;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException(
						"Operation not supported.");
			}
		};
	}

//	private class StackIterator implements Iterator<T> {
//		private Node<T> current;
//
//		public StackIterator() {
//			this.current = LinkedStack.this.first;
//		}
//
//		@Override
//		public boolean hasNext() {
//			return this.current != null;
//		}
//
//		@Override
//		public T next() {
//			T t = this.current.getType();
//
//			this.current = this.current.getNext();
//
//			return t;
//		}
//
//		@Override
//		public void remove() {
//			throw new UnsupportedOperationException("Operation not supported.");
//		}
//	}
}
