package com.lam.coursera.princeton.algorithms;

public class Node<T> {
	private T type;
	private Node<T> next;

	T getT() {
		return this.type;
	}

	public Node<T> getNext() {
		return this.next;
	}

	public void clear() {
		this.next = null;
		this.type = null;
	}
	
	public T getType() {
		return this.type;
	}
	
	@Override
	public String toString() {
		if (this.type != null) {
			return this.type.toString();
		} else {
			return "";
		}
	}

	public Node(T t) {
		super();
		this.type = t;
		this.next = null;
	}

	public Node() {
		super();
	}

	public void setT(T t) {
		this.type = t;
	}
	
	public void setNext(Node<T> node) {
		this.next = node;
	}
	
}
