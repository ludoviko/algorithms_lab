package com.algorithms.queue;

import org.junit.Test;

import junit.framework.TestCase;

import com.algorithms.exception.EmptyQueueException;

public abstract class AbstractFifoQueueTestCase extends TestCase {
	Queue queue;

	protected static final Object VALUE_A = "A";
	protected static final Object VALUE_B = "B";
	protected static final Object VALUE_C = "C";
	protected static final Object VALUE_D = "D";
	protected static final Object VALUE_E = "E";
	protected static final Object VALUE_F = "F";
	
	protected abstract Queue createQueue();
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		queue = this.createQueue();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		queue = null;
	}

	@Test
	public void testEmpty() {
		AbstractFifoQueueTestCase.assertTrue(queue.isEmpty());
		AbstractFifoQueueTestCase.assertEquals(0, queue.size());
		try {
		  queue.dequeue();
		  AbstractFifoQueueTestCase.fail("Failure: An exception was expected.");
		} catch (EmptyQueueException e) {
			// Ok
		}
	}

	@Test
	public void testEnqueuDequeu() {
		queue.enqueue(VALUE_A);
		queue.enqueue(VALUE_B);
		queue.enqueue(VALUE_C);
		AbstractFifoQueueTestCase.assertFalse(queue.isEmpty());
		AbstractFifoQueueTestCase.assertEquals(3, queue.size());
		
		Object a = queue.dequeue();
		Object b = queue.dequeue();
		Object c = queue.dequeue();

		testEmpty();
		AbstractFifoQueueTestCase.assertEquals(VALUE_A, a);
		AbstractFifoQueueTestCase.assertEquals(VALUE_B, b);
		AbstractFifoQueueTestCase.assertEquals(VALUE_C, c);
	}
	
	@Test
	public void testClear() {
		queue.enqueue(VALUE_A);
		queue.enqueue(VALUE_B);
		queue.enqueue(VALUE_C);
		AbstractFifoQueueTestCase.assertFalse(queue.isEmpty());
		AbstractFifoQueueTestCase.assertEquals(3, queue.size());
		
        queue.clear();
		
		testEmpty();
	}
	
}
