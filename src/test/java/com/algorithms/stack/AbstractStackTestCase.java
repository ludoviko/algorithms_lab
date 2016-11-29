package com.algorithms.stack;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.algorithms.exception.EmptyQueueException;
import com.algorithms.exception.EmptyStackException;
import com.algorithms.queue.Queue;
import com.algorithms.stack.Stack;

public abstract class AbstractStackTestCase extends TestCase {
	Stack stack;

	protected static final Object VALUE_A = "A";
	protected static final Object VALUE_B = "B";
	protected static final Object VALUE_C = "C";
	protected static final Object VALUE_D = "D";
	protected static final Object VALUE_E = "E";
	protected static final Object VALUE_F = "F";

	protected abstract Stack createStack();

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		stack = this.createStack();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		stack = null;
	}

	@Test
	public void testEmpty() {
		stack.clear();
		Assert.assertTrue(stack.isEmpty());
		Assert.assertEquals(0, stack.size());
		try {
			stack.pop();
			Assert.fail("Failure: An exception was expected.");
		} catch (EmptyStackException e) {
			// Ok
		}
	}

	@Test
	public void testPeekIntoAnEmptyStack() {

		stack.clear();
		Assert.assertTrue(stack.isEmpty());
		Assert.assertEquals(0, stack.size());
		try {
			stack.peek();
			Assert.fail("Failure: An exception was expected.");
		} catch (EmptyStackException e) {
			// Ok
		}
	}

	@Test
	public void testPushPop() {
		stack.push(VALUE_A);
		stack.push(VALUE_B);
		stack.push(VALUE_C);

		Assert.assertFalse(stack.isEmpty());
		Assert.assertEquals(3, stack.size());

		Object c = stack.pop();
		Object b = stack.pop();
		Object a = stack.pop();

		testEmpty();
		Assert.assertEquals(VALUE_A, a);
		Assert.assertEquals(VALUE_B, b);
		Assert.assertEquals(VALUE_C, c);
	}

	@Test
	public void testPeek() {
		stack.clear();
		stack.push(VALUE_A);
		stack.push(VALUE_B);
		stack.push(VALUE_C);
		Assert.assertFalse(stack.isEmpty());
		Assert.assertEquals(3, stack.size());

		Object c = stack.peek();
		Object c2 = stack.peek();
		Object c3 = stack.peek();

		testEmpty();
		Assert.assertEquals(VALUE_C, c);
		Assert.assertEquals(VALUE_C, c2);
		Assert.assertEquals(VALUE_C, c3);
	}

	@Test
	public void testClear() {
		stack.push(VALUE_A);
		stack.push(VALUE_B);
		stack.push(VALUE_C);
		Assert.assertFalse(stack.isEmpty());
		Assert.assertEquals(3, stack.size());

		stack.clear();

		testEmpty();
	}

}
