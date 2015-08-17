package com.lam.coursera.princeton.algorithms.queue;

import com.lam.coursera.princeton.algorithms.exception.EmptyQueueException;

public interface Queue_I<T> extends Iterable<T> {
	public void enqueue(T object);
	public T dequeue() throws EmptyQueueException;
	public void clear();
	public int size();
	public boolean isEmpty();
}
