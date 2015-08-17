package com.lam.coursera.princeton.algorithms.queue;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.lam.coursera.princeton.algorithms.exception.EmptyQueueException;

public abstract class AbstractQueueTest<T>  {
	@Rule
	public ExpectedException		exception	= ExpectedException.none();

	Queue_I<String>					queue;

	protected static final String	VALUE_A		= "A";
	protected static final String	VALUE_B		= "B";
	protected static final String	VALUE_C		= "C";
	protected static final String	VALUE_D		= "D";
	protected static final String	VALUE_E		= "E";
	protected static final String	VALUE_F		= "F";

	protected abstract Queue_I<String> createQueue();

	public void setUp() throws Exception {
		this.queue = this.createQueue();
	}

	public void tearDown() throws Exception {
		this.queue = null;
	}

	@Test(expected = EmptyQueueException.class)
	public void testEmptyQueueException() {
		Assert.assertTrue(this.queue.isEmpty());
		Assert.assertEquals(0, this.queue.size());
		this.queue.dequeue();
	}

	@Test
	public void testEnqueu() {
		this.queue.enqueue(VALUE_A);
		Assert.assertFalse(this.queue.isEmpty());
		Assert.assertEquals(1, this.queue.size());

		this.queue.enqueue(VALUE_B);
		Assert.assertFalse(this.queue.isEmpty());
		Assert.assertEquals(2, this.queue.size());

		this.queue.enqueue(VALUE_C);
		Assert.assertFalse(this.queue.isEmpty());
		Assert.assertEquals(3, this.queue.size());

	}

	@Test(expected = UnsupportedOperationException.class)
	public void testIterator() {
		this.queue.enqueue(VALUE_A);
		this.queue.enqueue(VALUE_B);
		this.queue.enqueue(VALUE_C);

		for (String data : this.queue) {
			Assert.assertNotNull(data);
			// System.out.println(data);
		}

		Iterator<String> itera = this.queue.iterator();
		itera.remove();
	}

	@Test
	public void testEnqueuDequeu() {
		this.queue.enqueue(VALUE_A);
		this.queue.enqueue(VALUE_B);
		this.queue.enqueue(VALUE_C);
		Assert.assertFalse(this.queue.isEmpty());
		Assert.assertEquals(3, this.queue.size());

		String a = this.queue.dequeue();
		String b = this.queue.dequeue();
		String c = this.queue.dequeue();

		Assert.assertEquals(VALUE_A, a);
		Assert.assertEquals(VALUE_B, b);
		Assert.assertEquals(VALUE_C, c);
		Assert.assertTrue(this.queue.isEmpty());
		
		this.queue.enqueue(VALUE_A);
		this.queue.enqueue(VALUE_B);
		this.queue.enqueue(VALUE_C);
		Assert.assertFalse(this.queue.isEmpty());
		Assert.assertEquals(3, this.queue.size());

	}

	@Test
	public void testClear() {
		this.queue.enqueue(VALUE_A);
		this.queue.enqueue(VALUE_B);
		this.queue.enqueue(VALUE_C);
		Assert.assertFalse(this.queue.isEmpty());
		Assert.assertEquals(3, this.queue.size());

		this.queue.clear();
		Assert.assertTrue(this.queue.isEmpty());
		Assert.assertEquals(0, this.queue.size());

		this.queue.enqueue(VALUE_A);
		this.queue.enqueue(VALUE_B);
		this.queue.enqueue(VALUE_C);
		Assert.assertFalse(this.queue.isEmpty());
		Assert.assertEquals(3, this.queue.size());
}

}
