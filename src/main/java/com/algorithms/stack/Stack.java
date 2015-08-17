package com.algorithms.stack;

import com.algorithms.exception.EmptyStackException;

public interface Stack {

	public void push(Object object);
	public Object pop() throws EmptyStackException;
	public Object peek() throws EmptyStackException;
	public void clear();
	public int size();
	public boolean isEmpty();
	
}
