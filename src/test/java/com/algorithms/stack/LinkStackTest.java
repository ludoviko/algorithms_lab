package com.algorithms.stack;

import org.junit.After;
import org.junit.Before;

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
