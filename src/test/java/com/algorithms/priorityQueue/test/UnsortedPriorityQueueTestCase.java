package com.algorithms.priorityQueue.test;

import java.util.Comparator;

import com.algorithms.priorityQueue.UnsortedPriorityQueue;
import com.algorithms.queue.Queue;

public class UnsortedPriorityQueueTestCase extends AbstractPriorityQueueTestCase {

	@Override
	protected Queue<String> createQueue(Comparator<String> comparator) {
		return new UnsortedPriorityQueue<String>(comparator);
	}

}
