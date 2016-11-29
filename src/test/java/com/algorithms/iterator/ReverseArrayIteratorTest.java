package com.algorithms.iterator;

import junit.framework.TestCase;

import com.algorithms.exception.IteratorOutOfBoundsException;


public class ReverseArrayIteratorTest extends TestCase {

	public void testIterationRespectsBounds() {
		Object[] array = new Object[] { "A", "B", "C", "D", "E", "F" };
		ReverseArrayIterator iterator = new ReverseArrayIterator(array, 1,3);
		
		iterator.first();
		ReverseArrayIteratorTest.assertFalse(iterator.isDone());
		ReverseArrayIteratorTest.assertSame(array[3], iterator.current());
		
		iterator.next();
		ReverseArrayIteratorTest.assertFalse(iterator.isDone());
		ReverseArrayIteratorTest.assertSame(array[2], iterator.current());

		iterator.next();
		ReverseArrayIteratorTest.assertFalse(iterator.isDone());
		ReverseArrayIteratorTest.assertSame(array[1], iterator.current());

		iterator.next();
        assertTrue(iterator.isDone());
        try {
        	iterator.current();
        	ReverseArrayIteratorTest.fail(); 
        } catch ( IteratorOutOfBoundsException out ) {
        	out.printStackTrace();
        };
    	
	};
	
	
	public void testBackwardsIteration() {
		Object[] array = new Object[] { "A", "B", "C"};
		ReverseArrayIterator iterator = new ReverseArrayIterator(array);
		
		iterator.last();
		ReverseArrayIteratorTest.assertFalse(iterator.isDone());
		ReverseArrayIteratorTest.assertSame(array[0], iterator.current());
		
		iterator.previous();
		ReverseArrayIteratorTest.assertFalse(iterator.isDone());
		ReverseArrayIteratorTest.assertSame(array[1], iterator.current());
		
		iterator.previous();
		ReverseArrayIteratorTest.assertFalse(iterator.isDone());
		ReverseArrayIteratorTest.assertSame(array[2], iterator.current());

		iterator.previous();
        assertTrue(iterator.isDone());
        try {
        	iterator.current();
        	ReverseArrayIteratorTest.fail(); 
        } catch ( IteratorOutOfBoundsException out ) {
        	out.printStackTrace();
        };
		
	}

}
