package com.algorithms.priorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.algorithms.exception.EmptyQueueException;
import com.algorithms.queue.Queue;

public class UnsortedPriorityQueue<T>  implements Queue<T> {
	Comparator<T> comparator;
	List<T> list;
	
	public UnsortedPriorityQueue(Comparator<T> comparator) {
		this.comparator = comparator;
		this.list = new ArrayList<T>();
	}
	
	
	public void enqueue(T object) {
		// shorcut, see solution from book 
		this.list.add(object);
		Collections.sort(this.list, this.comparator);
	}

	
	public T dequeue() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		}
		T object = this.list.remove(this.list.size() - 1);
		return object;
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

}
