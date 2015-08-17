package com.lam.coursera.princeton.algorithms.queue;

import java.util.Iterator;

import com.lam.coursera.princeton.algorithms.Node;
import com.lam.coursera.princeton.algorithms.exception.EmptyQueueException;

public class LinkedQueue<T> implements Queue_I<T> {
	private Node<T>	first;
	private Node<T>	last;
	private int		size;

	public LinkedQueue() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (T t : this) {
			builder.append(t.toString() + " ");
		}

		return builder.toString();
	}

	@Override
	public void enqueue(T t) {
		Node<T> node = new Node<T>(t);
		
		if (this.first == null) {
			// Empty queue, it is the same as asking this.isEmpty().
			this.first = node;
			this.last = node;
		} else {
			this.last.setNext(node);
			this.last = node;
		}
		
		this.size++;
	}

	@Override
	public T dequeue() throws EmptyQueueException {
		
		if (this.first == null) {
			throw new EmptyQueueException("The queue is empty.");
		}
		
		T t = this.first.getType();
		
		Node<T> old = this.first;  
		
		this.first = this.first.getNext();
		
		old.clear();
		old = null;

		if (this.first == null) {
			// Empty queue, it is the same as asking this.isEmpty().
			this.last = null;
		}
		
		this.size--;
		
		return t;
	}

	@Override
	public void clear() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Node<T>	current	= LinkedQueue.this.first;

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
}
