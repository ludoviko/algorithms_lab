package com.algorithms.iterator.tests;

import com.algorithms.iterator.ArrayIterator;
import com.algorithms.exception.IteratorOutOfBoundsException;

import junit.framework.TestCase;

public class ArrayIteratorTest extends TestCase {

	public void testIterationRespectsBounds() {
		Object[] array = new Object[] { "A", "B", "C", "D", "E", "F" };
		ArrayIterator iterator = new ArrayIterator(array, 1,3);
		
		iterator.first();
		ArrayIteratorTest.assertFalse(iterator.isDone());
		ArrayIteratorTest.assertSame(array[1], iterator.current());
		
		iterator.next();
		ArrayIteratorTest.assertFalse(iterator.isDone());
		ArrayIteratorTest.assertSame(array[2], iterator.current());

		iterator.next();
		ArrayIteratorTest.assertFalse(iterator.isDone());
		ArrayIteratorTest.assertSame(array[3], iterator.current());

		iterator.next();
        assertTrue(iterator.isDone());
        try {
        	iterator.current();
        	ArrayIteratorTest.fail(); 
        } catch ( IteratorOutOfBoundsException out ) {
        	out.printStackTrace();
        };
    	
	};
	
	
	public void testBackwardsIteration() {
		Object[] array = new Object[] { "A", "B", "C"};
		ArrayIterator iterator = new ArrayIterator(array);
		
		iterator.last();
		ArrayIteratorTest.assertFalse(iterator.isDone());
		ArrayIteratorTest.assertSame(array[2], iterator.current());
		
		iterator.previous();
		ArrayIteratorTest.assertFalse(iterator.isDone());
		ArrayIteratorTest.assertSame(array[1], iterator.current());
		
		iterator.previous();
		ArrayIteratorTest.assertFalse(iterator.isDone());
		ArrayIteratorTest.assertSame(array[0], iterator.current());

		iterator.previous();
        assertTrue(iterator.isDone());
        try {
        	iterator.current();
        	ArrayIteratorTest.fail(); 
        } catch ( IteratorOutOfBoundsException out ) {
        	out.printStackTrace();
        };
		
	}

}
