package com.lam.coursera.princeton.algorithms.UF;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.lam.coursera.princeton.algorithms.UF.UnionFind_I;

public abstract class UnionFindTestAbstract {
	protected abstract UnionFind_I createUF(int n);

	UnionFind_I uf;

	@Before
	public void setUp() throws Exception {
		this.uf = createUF(12);
	}

	@After
	public void tearDown() throws Exception {
		this.uf = null;
	}

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testConnected() {
		this.uf.union(4, 3);
		this.uf.union(3, 8);
		this.uf.union(6, 5);
		this.uf.union(9, 4);
		this.uf.union(2, 1);
		this.uf.union(5, 0);
		this.uf.union(7, 2);
		this.uf.union(6, 1);
		this.uf.union(7, 3);

		Assert.assertTrue(this.uf.areConnected(1, 2));
		Assert.assertFalse(this.uf.areConnected(1, 11));
	}

	@Test
	public void testConnected_RunTimeException() {
		this.uf.union(4, 3);
		this.uf.union(3, 8);
		this.uf.union(6, 5);
		this.uf.union(9, 4);
		this.uf.union(2, 1);
		this.uf.union(5, 0);
		this.uf.union(7, 2);
		this.uf.union(6, 1);
		this.uf.union(7, 3);

		exception.expect(IndexOutOfBoundsException.class);

		Assert.assertTrue(this.uf.areConnected(1, 2));
		Assert.assertFalse(this.uf.areConnected(1, 99));
	}

	@Test
	public void testConnected_2() {
		this.uf.union(6, 4);
		this.uf.union(6, 0);
		this.uf.union(6, 2);
		this.uf.union(6, 5);

		this.uf.union(4, 3);
		this.uf.union(4, 8);
		this.uf.union(4, 9);

		this.uf.union(2, 1);
		this.uf.union(2, 7);

		this.uf.union(2, 1);
		this.uf.union(2, 7);

		this.uf.union(1, 2);
		this.uf.union(7, 2);

		
		Assert.assertTrue(this.uf.areConnected(1, 1));
		Assert.assertTrue(this.uf.areConnected(2, 2));
		Assert.assertTrue(this.uf.areConnected(3, 3));

		Assert.assertTrue(this.uf.areConnected(6, 4));
		Assert.assertTrue(this.uf.areConnected(6, 0));
		Assert.assertTrue(this.uf.areConnected(6, 2));
		Assert.assertTrue(this.uf.areConnected(6, 5));

		Assert.assertTrue(this.uf.areConnected(4, 3));
		Assert.assertTrue(this.uf.areConnected(4, 8));
		Assert.assertTrue(this.uf.areConnected(4, 9));

		Assert.assertTrue(this.uf.areConnected(2, 1));
		Assert.assertTrue(this.uf.areConnected(1, 2));
		Assert.assertTrue(this.uf.areConnected(2, 7));
		Assert.assertTrue(this.uf.areConnected(7, 2));

		Assert.assertTrue(this.uf.areConnected(6, 3));
		Assert.assertTrue(this.uf.areConnected(6, 8));
		Assert.assertTrue(this.uf.areConnected(6, 9));
		Assert.assertTrue(this.uf.areConnected(6, 1));
		Assert.assertTrue(this.uf.areConnected(6, 7));

		Assert.assertFalse(this.uf.areConnected(11, 1));
		Assert.assertFalse(this.uf.areConnected(11, 2));
		Assert.assertFalse(this.uf.areConnected(11, 3));
		Assert.assertFalse(this.uf.areConnected(11, 4));
		Assert.assertFalse(this.uf.areConnected(10, 5));
		Assert.assertFalse(this.uf.areConnected(10, 6));
		Assert.assertFalse(this.uf.areConnected(10, 7));
		Assert.assertFalse(this.uf.areConnected(10, 8));
		Assert.assertFalse(this.uf.areConnected(10, 9));
	}

	@Ignore
	@Test
	public void testSize() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testConnected_3() {
		this.uf.union(0, 1);
		this.uf.union(1, 2);
		this.uf.union(2, 3);
        this.uf.union(3, 4);
        this.uf.union(4, 5);

        this.uf.union(6, 7);
        this.uf.union(7, 8);
        this.uf.union(8, 9);

        this.uf.union(9, 5);
        this.uf.union(10, 0);
        this.uf.union(11, 6);
	}
}
