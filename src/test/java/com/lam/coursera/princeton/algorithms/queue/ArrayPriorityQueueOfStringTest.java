package com.lam.coursera.princeton.algorithms.queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lam.coursera.princeton.algorithms.exception.EmptyQueueException;

public class ArrayPriorityQueueOfStringTest extends
	ArrayPriorityQueueAbstractOfStringTest {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testReadingNodes() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		this.queue.insert("A");
		this.queue.insert("E");
		this.queue.insert("I");
		this.queue.insert("G");
		
		Assert.assertTrue(this.queue.size() == 10);
		Assert.assertTrue(this.queue.first().equals("T"));
		
		Assert.assertTrue(this.queue.getParent(2) == "T" );
		Assert.assertTrue(this.queue.getParent(3) == "T" );

		Assert.assertTrue(this.queue.getChildRight(1) == "R" );
		Assert.assertTrue(this.queue.getChildLeft(1) == "P" );

		Assert.assertTrue(this.queue.getChildRight(2) == "H" );
		Assert.assertTrue(this.queue.getChildLeft(2) == "N" );

		Assert.assertTrue(this.queue.getChildRight(3) == "A" );
		Assert.assertTrue(this.queue.getChildLeft(3) == "O" );

		Assert.assertTrue(this.queue.getChildRight(4) == "I" );
		Assert.assertTrue(this.queue.getChildLeft(4) == "E" );

		Assert.assertTrue(this.queue.getChildLeft(5) == "G" );
}


	@Test(expected = AssertionError.class)
	public void testReadingNotesException() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		this.queue.insert("A");
		this.queue.insert("E");
		this.queue.insert("I");
		this.queue.insert("G");
		
		Assert.assertTrue(this.queue.size() == 10);
		Assert.assertTrue(this.queue.first().equals("T"));
		Assert.assertTrue(this.queue.getParent(1) == "T" );

	}

	@Test(expected = AssertionError.class)
	public void testReadingNotesException2() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		
		Assert.assertTrue(this.queue.first().equals("T"));
		
		Assert.assertTrue(this.queue.getChildRight(this.queue.size()) == "P" );
	}

	@Test(expected = AssertionError.class)
	public void testReadingNotesException3() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		
		Assert.assertTrue(this.queue.first().equals("T"));
		
		Assert.assertTrue(this.queue.getChildLeft(this.queue.size()) == "R" );
	}

	@Test
	public void testResizeBehaviour() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		this.queue.insert("A");
		this.queue.insert("E");
		this.queue.insert("I");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		
		Assert.assertTrue(this.queue.size() == 16);
		}

	
	@Test
	public void testResizeShrinnkBehaviour() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		this.queue.insert("A");
		this.queue.insert("E");
		this.queue.insert("I");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
			
		Assert.assertTrue(! this.queue.isEmpty());
		
		}
	

	@Test(expected=EmptyQueueException.class)
	public void testResizeShrinnkBehaviour_2() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		this.queue.insert("A");
		this.queue.insert("E");
		this.queue.insert("I");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("E");
		this.queue.insert("J");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("F");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("E");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("F");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("D");
		this.queue.insert("G");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("C");
		this.queue.insert("G");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("D");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("D");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("D");
		this.queue.insert("G");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("D");
		this.queue.insert("G");
		this.queue.insert("C");
		this.queue.insert("Y");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("W");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("C");
		this.queue.insert("G");
		this.queue.insert("X");
		this.queue.insert("B");
		this.queue.insert("D");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("B");
		this.queue.insert("Z");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		this.queue.insert("A");
		this.queue.insert("E");
		this.queue.insert("I");
		this.queue.insert("G");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("B");
		this.queue.insert("A");
		this.queue.insert("B");
		
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
		this.queue.deleteFirst();
			
		}

	
	@Override
	protected PriorityQueue_I<String> createQueue() {
		return new ArrayMaxPriorityQueue<String>(14);
	}
}
