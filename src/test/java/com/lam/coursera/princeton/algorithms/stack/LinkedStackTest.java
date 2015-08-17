package com.lam.coursera.princeton.algorithms.stack;

import org.junit.After;
import org.junit.Before;

public class LinkedStackTest extends AbstractStackTest<String> {

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
	protected Stack_I<String> createStack() {
		return new LinkedStack<String>();
	}
}
