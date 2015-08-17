package com.algorithms.list.test;

import com.algorithms.list.ArrayList;
import com.algorithms.list.List;

public class ArrayListTest extends AbstractListTestCase {

	@Override
	protected List createList() {
		return new ArrayList();
	};

	@Override
	protected List createList(int size) {
		return new ArrayList(size);
	};

	public void testResizeBeyoundInitialCapacity() {
		List list = this.createList(1);
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		ArrayListTest.assertEquals(3, list.size());
		
		ArrayListTest.assertSame(AbstractListTestCase.VALUE_A, list.getAt(0));
		ArrayListTest.assertSame(AbstractListTestCase.VALUE_B, list.getAt(1));
		ArrayListTest.assertSame(AbstractListTestCase.VALUE_C, list.getAt(2));
	};
	
	public void testDeleteFromLastElementInArray() {
		list.add( AbstractListTestCase.VALUE_A);
		list.add( AbstractListTestCase.VALUE_B);
		list.add( AbstractListTestCase.VALUE_C);

		ArrayListTest.assertEquals(3, list.size());

	    list.delete(2);	
	    list.delete(1);
	    
		ArrayListTest.assertEquals(1, list.size());
	    list.delete(0);
		ArrayListTest.assertEquals(0, list.size());
	};

	public void testResizeWhenDeleting() {
		int size = 4;
		
		for (int i = 0; i < size; i++) {
			list.add( AbstractListTestCase.VALUE_A);
			list.add( AbstractListTestCase.VALUE_B);
			list.add( AbstractListTestCase.VALUE_C);
			list.add( AbstractListTestCase.VALUE_D);
		};

		ArrayListTest.assertEquals(16, list.size());

		for (int i = 0; i < 8; i++) {
			list.delete( i );
		};

		ArrayListTest.assertEquals( 8, list.size());
		
		
	};

	
	
	

}
