package com.algorithms.queue;

import com.algorithms.exception.EmptyQueueException;

public interface Queue<T> {
	public void enqueue(T object);
	public T dequeue() throws EmptyQueueException;
	public void clear();
	public int size();
	public boolean isEmpty();
}
