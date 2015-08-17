package com.lam.coursera.princeton.algorithms.applications;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class InFixExpressionsTest {

	InFixExpressions expressions;
    double delta = 0.000001;
	
	@Before
	public void setUp() throws Exception {
		expressions = new InFixExpressions(); 
	}

	@After
	public void tearDown() throws Exception {
		expressions =  null;
	}

	@Test
	public void testProcess() {
		Assert.assertEquals(101.0, expressions.process("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"), delta);
	}

	@Test
	public void testProcessComplex() {
		Assert.assertEquals(1000, expressions.process("( 20 + 30 ) * ( 4 * 5 )"), delta);
	}

	@Test
	public void testProcessComplex2() {
		Assert.assertEquals(7.2, expressions.process("4.5 + 2.7"), delta);
	}

	@Ignore
	@Test
	public void testProcessComplex3() {
		Assert.assertEquals(-5, expressions.process("-3 -2"), delta);
	}

}
