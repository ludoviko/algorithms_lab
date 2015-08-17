package com.lam.coursera.princeton.algorithms.queue;

import com.lam.coursera.princeton.algorithms.exception.EmptyQueueException;

//public interface PriorityQueue_I<Key extends Comparable<Key>>  {
public interface PriorityQueue_I<Key extends Comparable<Key>>  {
	// insert a key into the priority queue
	public void insert(Comparable<Key> key);
	
	// return and remove the largest key
	public Comparable<Key> deleteFirst() throws EmptyQueueException;
	
	// return the largest key
	public Comparable<Key> first(); 

	public boolean isEmpty();
	public int size();
	
	public void clear();
	
	public Comparable<Key> getParent(int i);
	public Comparable<Key> getChildLeft(int i);
	public Comparable<Key> getChildRight(int i);

}
