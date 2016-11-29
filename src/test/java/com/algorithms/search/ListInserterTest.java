package com.algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.algorithms.search.IterativeBinaryListSearcher;
import com.algorithms.search.ListInserter;
import com.algorithms.sortStd.comparator.NaturalComparator;


import junit.framework.TestCase;

/**
 * Test cases for {@link ListInserter}.
 *
 */
public class ListInserterTest extends TestCase {
    private static final int TEST_SIZE = 1023;

    private ListInserter<Integer> inserter;
    private List<Integer> list;

    protected void setUp() throws Exception {
        super.setUp();

        this.inserter = new ListInserter<Integer>(new IterativeBinaryListSearcher<Integer>((Comparator<Integer>) NaturalComparator.INSTANCE));
        this.list = new ArrayList<Integer>(TEST_SIZE);
    }

    public void testDescendingInOrderInsertion() {
        for (int i = TEST_SIZE - 1; i >= 0; --i) {
            assertEquals( 0, this.inserter.insert(this.list, new Integer(i)));
        }
        verify();
    }

    public void testAscendingInOrderInsertion() {
        for (int i = 0; i < TEST_SIZE; ++i) {
            assertEquals(i, this.inserter.insert(this.list, new Integer(i)));
        }
        verify();
    }


    public void testRandomInsertion() {
        for (int i = 0; i < TEST_SIZE; ++i) {
        	this.inserter.insert(this.list, new Integer((int) (TEST_SIZE * Math.random())));
        }
        verify();
    }

    private void verify() {
        int previousValue = Integer.MIN_VALUE;
        Iterator<Integer> i = this.list.iterator();

        while (i.hasNext() ) {
            int currentValue = ((Integer) i.next()).intValue();
            assertTrue(currentValue >= previousValue);
            previousValue = currentValue;
        }
    }
}
