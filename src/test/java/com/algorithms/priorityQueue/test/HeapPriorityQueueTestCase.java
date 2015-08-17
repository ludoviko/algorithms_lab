package com.algorithms.priorityQueue.test;

import java.util.Comparator;

import org.junit.After;
import org.junit.Before;

import com.algorithms.priorityQueue.HeapOrderedPriorityQueue;
import com.algorithms.queue.Queue;

public class HeapPriorityQueueTestCase extends AbstractPriorityQueueTestCase {

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
//		fail("Not yet implemented");
//	}

	@Override
	protected Queue<String> createQueue(Comparator<String> comparator) {
		return new HeapOrderedPriorityQueue<String>(comparator);
	}

}
