package com.algorithms.priorityQueue;

import java.util.Comparator;

import com.algorithms.queue.Queue;

public class SortedPriorityQueueTestCase extends AbstractPriorityQueueTestCase {

	@Override
	protected Queue<String> createQueue(Comparator<String> comparator) {
		return new SortedPriorityQueue<String>(comparator);
	}

}
