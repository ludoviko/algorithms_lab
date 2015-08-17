package com.algorithms.priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.algorithms.exception.EmptyQueueException;
import com.algorithms.queue.Queue;
// LIFO queue
public class SortedPriorityQueue<T>  implements Queue<T> {
	Comparator<T> comparator;
	List<T> list;
	
	public SortedPriorityQueue(Comparator<T> comparator) {
		this.comparator = comparator;
		this.list = new ArrayList<T>();
	}
	
	
	public void enqueue(T object) {
		int position = this.list.size();
		 
		while ( position > 0 && this.comparator.compare(this.list.get(position -1), object) > 0  ) {
              position--; 			
		}
		this.list.add(position, object);
	}

	
	public T dequeue() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		}
		T object = this.list.remove( this.list.size() - 1 );
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
