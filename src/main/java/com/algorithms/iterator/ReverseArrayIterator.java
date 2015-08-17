package com.algorithms.iterator;

import com.algorithms.exception.IteratorOutOfBoundsException;

//import com.algorithms.exception.IteratorOutOfBoundsException;


public class ReverseArrayIterator implements Iterator { 

	private final ArrayIterator arrayIterator;
	
	
	public ReverseArrayIterator(Object[] array, int lowerBound, int length ) {
		this.arrayIterator = new ArrayIterator(array, lowerBound, length);
	}

	public ReverseArrayIterator(Object[] array) {
		this.arrayIterator = new ArrayIterator(array);
	}

	ReverseArrayIterator(ArrayIterator arrayIterator) {
		this.arrayIterator = arrayIterator;
	};
	
	
	public void last() {
       this.arrayIterator.first();
}

	public void first() {
	       this.arrayIterator.last();
	}

	public boolean isDone() {
		return this.arrayIterator.isDone();
	};

	public boolean hasNext() {
		return this.arrayIterator.hasNext();
	}

	public void next() {
		this.arrayIterator.previous();
	}

	public void previous() {
		this.arrayIterator.next();
	}

	public Object current() throws IteratorOutOfBoundsException {
		return this.arrayIterator.current();
	}

}
