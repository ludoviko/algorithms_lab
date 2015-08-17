package com.lam.coursera.princeton.algorithms.queue;

import java.util.Comparator;

import com.lam.coursera.princeton.algorithms.comparator.NaturalComparator;
import com.lam.coursera.princeton.algorithms.exception.EmptyQueueException;

public class ArrayMaxPriorityQueue<Key extends Comparable<Key>> implements
		PriorityQueue_I<Key> {

	private Comparable<Key>[] keys;

	private static int CAPACITY = 128;
	private int size;

	protected Comparator<Key> comparator;
	
	public ArrayMaxPriorityQueue() {
		// Java does not deal well with parametrized arrays.
		// The array is 1 based, the position 0 is not used.
		this.keys = new Comparable[CAPACITY + 1];
		this.size = 0;
		this.comparator = NaturalComparator.INSTANCE;
	};

//	public ArrayMaxPriorityQueue(Comparable<Key>[] keys, int size) {
//		this.keys = keys;
//		this.size = size;
//	};

	public ArrayMaxPriorityQueue(int capacity) {
		// Java does not deal well with parametrized arrays.
		// The array is 1 based, the position 0 is not used.
		this.keys = new Comparable[capacity + 1];
		this.size = 0;
	};

	@Override
	public void insert(Comparable<Key> key) {
		
		// The array is 1 based, the position 0 is not used.
		if ( this.size() ==  this.keys.length - 1 ) {
			// The capacity of the keys is double.
			this.resize(2 * this.keys.length );
		}
		
		// The array is 1 based, the position 0 is not used.
		this.keys[++this.size] = key;
		this.swin(this.size);
	}

	
	private void resize(int capacity) {
		Comparable<Key>[] resizedKeys = new Comparable[capacity];  
		System.arraycopy(this.keys, 1, resizedKeys, 1, this.size());
		this.keys = resizedKeys;
	}
	
	@Override
	public Comparable<Key> deleteFirst() {
		
		if (this.isEmpty()) {
			throw new EmptyQueueException("The queue is empty.");
		}
		
		Comparable<Key> key = this.keys[1];
		this.swap(1, this.size);
		this.keys[this.size--] = null;
		this.sink(1);
		
		// The array is 1 based, the position 0 is not used.
		// Halve the capacity of the array when it is one-quarter full.
		if ( this.size() ==  this.keys.length / 4 && this.size() > CAPACITY / 4  ) {
			// The capacity of the keys is double.
			this.resize( this.keys.length / 2);
		}

		return key;
	}

	@Override
	public Comparable<Key> first() {
		return this.keys[1];
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		this.size = 0;
		for (Comparable<Key> k : this.keys) {
			k = null;
		}
	}

	@Override
	public Comparable<Key> getParent(int i) {
		assert (i > 0) : "i must be greater than zero.";
		assert (i <= this.size()) : "i must not greater than size.";

		if (i == 1) {
			return null;
		} else {
			return this.keys[i / 2];
		}
	}

	@Override
	public Comparable<Key> getChildLeft(int i) {
		assert (i > 0) : "i must be greater than zero.";
		assert (i <= this.size() / 2) : "i must not greater than size / 2.";

		return this.keys[i * 2];
	}

	@Override
	public Comparable<Key> getChildRight(int i) {
		assert (i > 0) : "i must be greater than zero.";
		assert (i <= this.size() / 2 + 1) : "i must not greater than (size / 2) + 1.";

		return this.keys[i * 2 + 1];
	}

	private void swap(int i, int j) {
		if (i == j) {
			return;
		}

		Comparable<Key> aux = this.keys[i];
		this.keys[i] = this.keys[j];
		this.keys[j] = aux;
	}

	private boolean less(int i, int j) {
		return this.keys[i].compareTo((Key) this.keys[j]) < 0;
	}

	private boolean greater(int i, int j) {
		return this.keys[i].compareTo((Key) this.keys[j]) > 0;
	}

	// Violation: Child's key becomes larger key than its parent key.
	// To eliminate the violation:
	// Exchange child's key with parenet's key.
	// Repeat until heap ordered is restored.
	// Also known as: Promotion in a heap.
	private void swin(int k) {
		while (k > 1 && this.greater(k, k / 2)  ) {
			this.swap(k, k / 2);
			k = k / 2;
		}
	}

	// Violation: Parent's key becomes smaller key than any of its children's.
	// To eliminate the violation:
	// Exchange child's key with key in larger child.
	// Repeat until heap ordered is restored.
	// Also known as: Better subordinated promoted.
	private void sink(int k) {
		while (k * 2 <= this.size && k * 2 + 1 <= this.size) {
			if (this.less(k, k * 2) || this.less(k, k * 2 + 1)) {
			} else {
				break;
			}
			if (this.greater(k * 2, k * 2 + 1)) {
				this.swap(k, k * 2);
				k = 2 * k;
			} else {
				this.swap(k, k * 2 + 1);
				k = 2 * k + 1;
			}
		}
	}

	public static void main(String[] strings) {
	}

}
