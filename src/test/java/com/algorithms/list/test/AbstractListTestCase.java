package com.algorithms.list.test;


import com.algorithms.exception.IteratorOutOfBoundsException;
import com.algorithms.iterator.Iterator;
import com.algorithms.list.List;

import junit.framework.TestCase;

public abstract class AbstractListTestCase extends TestCase {

	protected static final Object VALUE_A = "A";
	protected static final Object VALUE_B = "B";
	protected static final Object VALUE_C = "C";
	protected static final Object VALUE_D = "D";
	protected static final Object VALUE_E = "E";
	protected static final Object VALUE_F = "F";
	
	protected abstract List createList();
	protected abstract List createList(int size);
	
	List list;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		list = this.createList();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		list = null;
	}
	
	public void testInsertIntoEmptyList() {
		TestCase.assertEquals(0, list.size());
		TestCase.assertTrue(list.isEmpty());
		
		list.insertAt(0, AbstractListTestCase.VALUE_A);
		TestCase.assertEquals(1, list.size());
		TestCase.assertFalse(list.isEmpty());
		TestCase.assertTrue(list.hasMore());
		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
	};

	public void testInsertBetweenElements() {
		list.insertAt(0, AbstractListTestCase.VALUE_A);
		list.insertAt(1, AbstractListTestCase.VALUE_B);
		list.insertAt(2, AbstractListTestCase.VALUE_C);

		TestCase.assertFalse(list.isEmpty());
		TestCase.assertTrue(list.hasMore());
		
		list.insertAt(1, AbstractListTestCase.VALUE_D);
		TestCase.assertEquals(4, list.size());

		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_D, list.getAt(1));
		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(2));
		TestCase.assertSame(AbstractListTestCase.VALUE_C, list.getAt(3));
	};
	
	public void testInsertAfterLastElements() {
		list.insertAt(0, AbstractListTestCase.VALUE_A);
		list.insertAt(1, AbstractListTestCase.VALUE_B);
		list.insertAt(2, AbstractListTestCase.VALUE_C);
		TestCase.assertEquals(3, list.size());
		
		list.insertAt(3, AbstractListTestCase.VALUE_D);
		TestCase.assertEquals(4, list.size());
		TestCase.assertSame(AbstractListTestCase.VALUE_D, list.getAt(3));

	};
	
	public void testInsertOutOfBounds() {
		try { 
			list.insertAt(-1, AbstractListTestCase.VALUE_A);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
			e.printStackTrace();
		};

		try { 
			list.insertAt(1, AbstractListTestCase.VALUE_A);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
			e.printStackTrace();
		};
	};

	
	public void testAdd() {
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		TestCase.assertEquals(3, list.size());
		
		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(1));
		TestCase.assertSame(AbstractListTestCase.VALUE_C, list.getAt(2));
	};

	public void testSet() {
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		Object d = list.setAt( 0, AbstractListTestCase.VALUE_D);
		Object e = list.setAt( 1, AbstractListTestCase.VALUE_E);
		Object f = list.setAt( 2, AbstractListTestCase.VALUE_F);

		TestCase.assertEquals(3, list.size());

		TestCase.assertSame(AbstractListTestCase.VALUE_D, d);
		TestCase.assertSame(AbstractListTestCase.VALUE_E, e);
		TestCase.assertSame(AbstractListTestCase.VALUE_F, f);
		
		try { 
			list.insertAt(list.size() + 1, AbstractListTestCase.VALUE_A);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException indexOutE ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
			indexOutE.printStackTrace();
		};
	};

	public void testGetOutOfBounds() {
		Object object;
		
		try { 
			object = list.getAt( -1);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
			e.printStackTrace();
		};
		
		try { 
			object = list.getAt( 0 );
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
			e.printStackTrace();
		};

		try { 
			object = list.getAt( 1);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
			e.printStackTrace();
		};
		
		list.add( AbstractListTestCase.VALUE_A );
		
		try { 
			object = list.getAt( list.size() );
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
			e.printStackTrace();
		};
	};

	public void testSetOutOfBounds() {
		Object former;
		
		try { 
			former = list.setAt( -1, AbstractListTestCase.VALUE_A);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
		};

		// The list is empty
		try { 
			former = list.setAt( 0, AbstractListTestCase.VALUE_A);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
		};
		
		try { 
			former = list.setAt( list.size() + 1 , AbstractListTestCase.VALUE_A);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
		};
		
		list.add( AbstractListTestCase.VALUE_A );

		try { 
			former = list.setAt( list.size() + 1 , AbstractListTestCase.VALUE_B);
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
		};
	};

	public void testDeleteAtOnlyElement() {
		list.add( AbstractListTestCase.VALUE_A);

		Object deleted = list.delete( 0 );

		TestCase.assertEquals(0, list.size());
		TestCase.assertSame(AbstractListTestCase.VALUE_A, deleted);
	};
	
	public void testDeleteFirstElement() {
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(1));
		TestCase.assertSame(AbstractListTestCase.VALUE_C, list.getAt(2));

		TestCase.assertEquals(3, list.size());
		
		Object deleted = list.delete( 0 );
		TestCase.assertEquals(2, list.size());
		TestCase.assertSame(AbstractListTestCase.VALUE_A, deleted);

		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_C, list.getAt(1));
	};

	public void testDeleteLastElement() {
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(1));
		TestCase.assertSame(AbstractListTestCase.VALUE_C, list.getAt(2));

		TestCase.assertEquals(3, list.size());
		
		Object deleted = list.delete( list.size() - 1 );
		TestCase.assertEquals(2, list.size());
		TestCase.assertSame(AbstractListTestCase.VALUE_C, deleted);

		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(1));
	};
	
	public void testDeleteMiddleElement() {
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(1));
		TestCase.assertSame(AbstractListTestCase.VALUE_C, list.getAt(2));

		TestCase.assertEquals(3, list.size());
		
		Object deleted = list.delete(  1 );
		TestCase.assertEquals(2, list.size());
		
		TestCase.assertSame(AbstractListTestCase.VALUE_B, deleted);

		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_C, list.getAt(1));
	};

	public void testDeleteOutOfBounds() {
		Object deleted;
		
		try { 
			deleted = list.delete( -1 );
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
		};

		// The list is empty
		try { 
			deleted = list.delete( 0 );
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
		};
		
		try { 
			deleted = list.delete( 1 );
			AbstractListTestCase.fail();
		} catch ( IndexOutOfBoundsException e ){
			System.out.println("Expected IndexOutOfBoundsException: Ok");
		};
	};
	
	public void testDeleteByValue() {

		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_A);

		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(1));
		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(2));

		TestCase.assertEquals(3, list.size());
		
		boolean deleted = list.delete( AbstractListTestCase.VALUE_A );
		TestCase.assertTrue(deleted);
		TestCase.assertEquals(2, list.size());
		TestCase.assertSame(AbstractListTestCase.VALUE_B, list.getAt(0));
		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(1));
		
		deleted = list.delete( AbstractListTestCase.VALUE_B );
		TestCase.assertTrue(deleted);
		TestCase.assertEquals(1, list.size());
		TestCase.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		
		deleted = list.delete( AbstractListTestCase.VALUE_C );
		TestCase.assertFalse(deleted);
		TestCase.assertEquals(1, list.size());
	};

	public void testEmptyIteration() {
		Iterator iterator = list.iterator();
		
		TestCase.assertTrue(iterator.isDone());
		
		try {
		       iterator.current();
		       TestCase.fail();
		} catch ( IteratorOutOfBoundsException e ) {
		};
	};

	public void testForwardIteration() {
		
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		Iterator iterator = list.iterator();
		TestCase.assertFalse(iterator.isDone());
	
		iterator.first();
		TestCase.assertFalse(iterator.isDone());
		TestCase.assertSame(AbstractListTestCase.VALUE_A, iterator.current());
       
		iterator.next();
		TestCase.assertFalse(iterator.isDone());
		TestCase.assertSame(AbstractListTestCase.VALUE_B, iterator.current());
        
		iterator.next();
		TestCase.assertFalse(iterator.isDone());
		TestCase.assertSame(AbstractListTestCase.VALUE_C, iterator.current());

		iterator.next();
		TestCase.assertTrue(iterator.isDone());
		try {
		       iterator.current();
		       TestCase.fail();
		} catch ( IteratorOutOfBoundsException e ) {
		};
	};

	public void testBackwardIteration() {

		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		Iterator iterator = list.iterator();
		TestCase.assertFalse(iterator.isDone());
		
		iterator.last();
		TestCase.assertFalse(iterator.isDone());
		TestCase.assertSame(AbstractListTestCase.VALUE_C, iterator.current());
       
		iterator.previous();
		TestCase.assertFalse(iterator.isDone());
		TestCase.assertSame(AbstractListTestCase.VALUE_B, iterator.current());
        
		iterator.previous();
		TestCase.assertFalse(iterator.isDone());
		TestCase.assertSame(AbstractListTestCase.VALUE_A, iterator.current());

		iterator.previous();
		TestCase.assertTrue(iterator.isDone());
		try {
		       iterator.current();
		       TestCase.fail();
		} catch ( IteratorOutOfBoundsException e ) {
		};
	};

	public void testIndexOf() {

		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);
	    TestCase.assertEquals( list.indexOf(AbstractListTestCase.VALUE_A), 0 );
	    TestCase.assertEquals( list.indexOf(AbstractListTestCase.VALUE_B), 1 );
	    TestCase.assertEquals( list.indexOf(AbstractListTestCase.VALUE_C), 2 );
	    TestCase.assertEquals( list.indexOf(AbstractListTestCase.VALUE_D), -1 );
	};

	public void testContains() {
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);
		
		TestCase.assertTrue(list.contains(AbstractListTestCase.VALUE_A));
		TestCase.assertTrue(list.contains(AbstractListTestCase.VALUE_B));
		TestCase.assertTrue(list.contains(AbstractListTestCase.VALUE_C));
		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_D));

		list.clear();
		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_A));
		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_B));
		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_C));
		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_D));
	};

	public void testClear() {
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		TestCase.assertFalse(list.isEmpty());
		TestCase.assertEquals(3, list.size());
		
		list.clear();

		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_A));
		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_B));
		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_C));
		TestCase.assertFalse(list.contains(AbstractListTestCase.VALUE_D));

		TestCase.assertTrue(list.isEmpty());
		TestCase.assertEquals(0, list.size());
	};

}
