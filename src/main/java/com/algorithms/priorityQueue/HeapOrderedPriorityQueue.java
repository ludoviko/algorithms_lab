package com.algorithms.priorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.algorithms.exception.EmptyQueueException;
import com.algorithms.queue.Queue;
import com.algorithms.sortStd.comparator.NaturalComparator;

public class HeapOrderedPriorityQueue<T> implements Queue<T> {

	Comparator<T> comparator;
	List<T> list;
	
	public HeapOrderedPriorityQueue(Comparator<T> comparator) {
		this.comparator = comparator;
		this.list = new ArrayList<T>();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HeapOrderedPriorityQueue<String> heap = new HeapOrderedPriorityQueue<String>((Comparator<String>) NaturalComparator.INSTANCE);
		
		heap.enqueue("X");
		heap.enqueue("M");
		heap.enqueue("K");
		heap.enqueue("E");
		heap.enqueue("A");
		heap.enqueue("F");
		heap.enqueue("D");
		heap.enqueue("D");
		heap.enqueue("B");
		heap.enqueue("P");
		heap.enqueue("Z");
		heap.dequeue();
	}

	
	public void enqueue(T object) {
		if (this.isEmpty()) {
			this.list.add(object);
			return;
		} else {
			boolean flag = true;
			this.list.add(object);
			int i = this.list.size() - 1;
			while (flag) {
				// swim to the top
				T parent = this.getParent(i); 
				if ( this.comparator.compare(object, parent) > 0 ) {
					this.swap(parent, object);
					i = ( i - 1) / 2;
				} else {
					flag = false;
				}
			}
		}
	}

	private void swap(T first, T second) {
		int iS = this.list.indexOf(second); 
		this.list.set(this.list.indexOf(first), second);
		this.list.set(iS, first);
	}

	private T getParent(int position) {
		return this.list.get( ( position - 1) / 2 );
	}

	
	public T dequeue() throws EmptyQueueException {
		if (this.isEmpty()) {
			throw new EmptyQueueException();
		}
		
		T t = null;
		T object = this.list.remove(0);
		if ( this.list.isEmpty() ) {
		} else {
			this.list.add(0, this.list.remove(this.list.size() - 1));
			t = this.list.get(0);
		}

		int i = 0;
		boolean flag = true;
		while ( flag ) {
			// sink to the bottom
			if (  2 * i + 1 < this.list.size() && this.comparator.compare(this.list.get(2 * i + 1 ), t) > 0 ) {
				this.swap(this.list.get( 2 * i + 1 ), t);
			} else if ( 2 * i + 2 < this.list.size() && this.comparator.compare(this.list.get( 2 * i + 2 ), t) > 0 ) {
				this.swap(this.list.get( 2 * i + 2 ), t);
			} else {
				flag = false;
			}
			i = this.list.indexOf(t); 
		}
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
