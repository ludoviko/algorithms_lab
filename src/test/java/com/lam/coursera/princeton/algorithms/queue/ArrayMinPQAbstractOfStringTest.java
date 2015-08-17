package com.lam.coursera.princeton.algorithms.queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lam.coursera.princeton.algorithms.exception.EmptyQueueException;

public abstract class ArrayMinPQAbstractOfStringTest {

	protected abstract PriorityQueue_I<String> createQueue();

	PriorityQueue_I<String>	queue;

	@Before
	public void setUp() throws Exception {
		this.queue = this.createQueue();
	}

	@After
	public void tearDown() throws Exception {
		this.queue = null;
	}

	@Test
	public void testInsert() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");
		this.queue.insert("N");
		this.queue.insert("H");
		this.queue.insert("O");
		this.queue.insert("A");
		this.queue.insert("B");
		this.queue.insert("C");
		this.queue.insert("G");

		Assert.assertTrue(this.queue.size() == 10);
		Assert.assertTrue(this.queue.first().equals("A"));

		this.queue.insert("S");
		Assert.assertTrue(this.queue.first().equals("A"));
		Assert.assertTrue(this.queue.size() == 11);

		this.queue.deleteFirst();
		Assert.assertTrue(this.queue.first().equals("B"));
		Assert.assertTrue(this.queue.size() == 10);

		this.queue.deleteFirst();
		Assert.assertTrue(this.queue.first().equals("C"));
		Assert.assertTrue(this.queue.size() == 9);

		this.queue.insert("A");
		Assert.assertTrue(this.queue.first().equals("A"));
		Assert.assertTrue(this.queue.size() == 10);
		Assert.assertFalse(this.queue.isEmpty());

		this.queue.clear();
		Assert.assertTrue(this.queue.size() == 0);
		Assert.assertTrue(this.queue.isEmpty());
	}

	@Test(expected = EmptyQueueException.class)
	public void testEmptyQueueException() {
		this.queue.insert("T");
		this.queue.insert("P");
		this.queue.insert("R");

		this.queue.clear();
		Assert.assertTrue(this.queue.size() == 0);
		Assert.assertTrue(this.queue.isEmpty());

		this.queue.deleteFirst();
	}

	@Test
	public void testClear() {
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
		Assert.assertTrue(this.queue.first().equals("A"));

		this.queue.clear();
		Assert.assertTrue(this.queue.size() == 0);
		Assert.assertTrue(this.queue.isEmpty());
	}
}
