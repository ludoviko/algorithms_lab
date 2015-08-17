package com.lam.coursera.princeton.algorithms.queue;

import org.junit.After;
import org.junit.Before;


public class LinkedQueueTest extends AbstractQueueTest<String> {
	
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
	
	@Override
	protected Queue_I<String> createQueue() {
		return new LinkedQueue<String>();
	}
}
