package com.lam.coursera.princeton.algorithms.bag;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LinkedBagTest extends AbstractBagTest<String> {

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}


	@Override
	protected Bag_I<String> createBag() {
		return new LinkedBag<String>();
	}

}
