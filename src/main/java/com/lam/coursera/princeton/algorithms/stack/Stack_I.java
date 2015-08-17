package com.lam.coursera.princeton.algorithms.stack;

import com.lam.coursera.princeton.algorithms.exception.EmptyStackException;

public interface Stack_I<T> extends Iterable<T> {
	public void push(T object);
	public T pop() throws EmptyStackException;
	public T peek() throws EmptyStackException;
	public void clear();
	public int size();
	public boolean isEmpty();
	
}
