package com.lam.coursera.princeton.algorithms.bag;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public abstract class AbstractBagTest<T>  {
	Bag_I<String>					bag;

	protected static final String	VALUE_A	= "A";
	protected static final String	VALUE_B	= "B";
	protected static final String	VALUE_C	= "C";
	protected static final String	VALUE_D	= "D";
	protected static final String	VALUE_E	= "E";
	protected static final String	VALUE_F	= "F";

	protected abstract Bag_I<String> createBag();

	public void setUp() throws Exception {
		this.bag = this.createBag();
	}

	public void tearDown() throws Exception {
		this.bag = null;
	}

	@Rule
	public ExpectedException	exception	= ExpectedException.none();


	@Test()
	public void testAdd() {
		this.bag.add(VALUE_A);
		this.bag.add(VALUE_B);
		this.bag.add(VALUE_C);

		Assert.assertFalse(this.bag.isEmpty());
		Assert.assertEquals(3, this.bag.size());
	}

	@Test
	public void testClear() {
		this.bag.add(VALUE_A);
		this.bag.add(VALUE_B);
		this.bag.add(VALUE_C);
		
		Assert.assertFalse(this.bag.isEmpty());
		Assert.assertEquals(3, this.bag.size());

		this.bag.clear();
		Assert.assertTrue(this.bag.isEmpty());
		Assert.assertEquals(0, this.bag.size());

		this.bag.add(VALUE_A);
		this.bag.add(VALUE_B);
		this.bag.add(VALUE_C);
		
		Assert.assertFalse(this.bag.isEmpty());
		Assert.assertEquals(3, this.bag.size());
}

	@Test(expected = UnsupportedOperationException.class)
	public void testIterator() {
		this.bag.add(VALUE_A);
		this.bag.add(VALUE_B);
		this.bag.add(VALUE_C);

		Iterator<String> itera = this.bag.iterator();

		while (itera.hasNext()) {
			Assert.assertNotNull(itera.next());
		}

		for (String data : this.bag) {
			Assert.assertNotNull(data);
			// System.out.println(data);
		}

		itera = this.bag.iterator();
		itera.remove();
	}
}
