package com.algorithms.stack;

import com.algorithms.exception.EmptyStackException;
import com.algorithms.list.LinkedList;
import com.algorithms.list.List;

public class ListStack implements Stack {

	private List list = new LinkedList();
	
	public void push(Object object) {
		this.list.add(object);
	}

	public Object pop() throws EmptyStackException {
		if (this.list.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.list.delete(this.list.size() -1);
	}

	public Object peek() throws EmptyStackException {
		if (this.list.isEmpty()) {
			throw new EmptyStackException();
		}
		return this.list.getAt(this.list.size() -1);
	}

	public void clear() {
		this.list.clear();
	}

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.list.isEmpty(); 
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
