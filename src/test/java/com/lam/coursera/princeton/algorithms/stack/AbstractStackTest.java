package com.lam.coursera.princeton.algorithms.stack;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.lam.coursera.princeton.algorithms.exception.EmptyStackException;

public abstract class AbstractStackTest<T>  {
	Stack_I<String>					stack;

	protected static final String	VALUE_A	= "A";
	protected static final String	VALUE_B	= "B";
	protected static final String	VALUE_C	= "C";
	protected static final String	VALUE_D	= "D";
	protected static final String	VALUE_E	= "E";
	protected static final String	VALUE_F	= "F";

	protected abstract Stack_I<String> createStack();

	public void setUp() throws Exception {
		this.stack = this.createStack();
	}

	public void tearDown() throws Exception {
		this.stack = null;
	}

	@Rule
	public ExpectedException	exception	= ExpectedException.none();

	@Test(expected = EmptyStackException.class)
	public void testPeekIntoAnEmptyStack() {
		this.stack.clear();
		Assert.assertTrue(this.stack.isEmpty());
		Assert.assertEquals(0, this.stack.size());

		this.stack.peek();
	}

	@Test(expected = EmptyStackException.class)
	public void testPopIntoAnEmptyStack() {
		this.stack.clear();
		Assert.assertTrue(this.stack.isEmpty());
		Assert.assertEquals(0, this.stack.size());

		this.stack.pop();
	}

	
	@Test()
	public void testPushPop() {
		this.stack.push(VALUE_A);
		this.stack.push(VALUE_B);
		this.stack.push(VALUE_C);

		Assert.assertFalse(this.stack.isEmpty());
		Assert.assertEquals(3, this.stack.size());

		String c = this.stack.pop();
		String b = this.stack.pop();
		String a = this.stack.pop();

		Assert.assertEquals(VALUE_A, a);
		Assert.assertEquals(VALUE_B, b);
		Assert.assertEquals(VALUE_C, c);
	}

	@Test
	public void testPeek() {
		this.stack.clear();
		this.stack.push(VALUE_A);
		this.stack.push(VALUE_B);
		this.stack.push(VALUE_C);
		Assert.assertFalse(this.stack.isEmpty());
		Assert.assertEquals(3, this.stack.size());

		Object c = this.stack.peek();
		Object c2 = this.stack.peek();
		Object c3 = this.stack.peek();

		Assert.assertEquals(VALUE_C, c);
		Assert.assertEquals(VALUE_C, c2);
		Assert.assertEquals(VALUE_C, c3);
	}

	@Test
	public void testClear() {
		this.stack.push(VALUE_A);
		this.stack.push(VALUE_B);
		this.stack.push(VALUE_C);
		
		Assert.assertFalse(this.stack.isEmpty());
		Assert.assertEquals(3, this.stack.size());
		
		this.stack.clear();
		Assert.assertTrue(this.stack.isEmpty());
		Assert.assertEquals(0, this.stack.size());
		
		this.stack.push(VALUE_A);
		this.stack.push(VALUE_B);
		this.stack.push(VALUE_C);
		
		Assert.assertFalse(this.stack.isEmpty());
		Assert.assertEquals(3, this.stack.size());
}

	@Test(expected = UnsupportedOperationException.class)
	public void testIterator() {
		this.stack.push(VALUE_A);
		this.stack.push(VALUE_B);
		this.stack.push(VALUE_C);

		Iterator<String> itera = this.stack.iterator();

		while (itera.hasNext()) {
			Assert.assertNotNull(itera.next());
		}

		for (String data : this.stack) {
			Assert.assertNotNull(data);
			// System.out.println(data);
		}

		itera = this.stack.iterator();
		itera.remove();
	}
}
