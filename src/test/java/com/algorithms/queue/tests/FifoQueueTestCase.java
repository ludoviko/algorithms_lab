package com.algorithms.queue.tests;

import com.algorithms.queue.ListFifoQueue;
import com.algorithms.queue.Queue;

public class FifoQueueTestCase extends AbstractFifoQueueTestCase {

	@Override
	protected Queue createQueue() {
		return new ListFifoQueue();
	}

	
	
}
