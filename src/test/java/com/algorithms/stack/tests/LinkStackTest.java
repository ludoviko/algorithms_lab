package com.algorithms.stack.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.algorithms.stack.ListStack;
import com.algorithms.stack.Stack;

public class LinkStackTest extends AbstractStackTestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

//	@Test
//	public void test() {
//	//	fail("Not yet implemented");
//	}

	@Override
	protected Stack createStack() {
		return new ListStack();
	}

}
