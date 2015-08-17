package com.algorithms.iterator;

import com.algorithms.exception.IteratorOutOfBoundsException;

public class ArrayIterator implements Iterator { 
   
	private int lowerBound;
	private int upperBound;
	private int current;
	Object[] array;
	
	public ArrayIterator(Object[] array, int lowerBound, int length ) {
		this.lowerBound = 0;
		this.upperBound =  length - 1;
		this.array = new Object[length];
		System.arraycopy(array, lowerBound, this.array, 0, length);
	}

	public ArrayIterator(Object[] array) {
		this.lowerBound = 0;
		this.upperBound =  array.length - 1;
		this.array = array; 
	}

	public void last() {
		  this.current = this.upperBound; 
	}

	public void first() {
		this.current = this.lowerBound;
	}

	public boolean isDone() {
		return this.current > this.upperBound || this.current < this.lowerBound;
	};

	public boolean hasNext() {
		return ! this.isDone();
	}

	public void next() {
		++this.current;
	}

	public void previous() {
		--this.current;
	}

	public Object current() throws IteratorOutOfBoundsException {
		if (this.isDone()) {
			throw new IteratorOutOfBoundsException();
		};
			
		return this.array[this.current];
	}

}
