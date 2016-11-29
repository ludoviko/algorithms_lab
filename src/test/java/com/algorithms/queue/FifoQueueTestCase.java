package com.algorithms.queue;

public class FifoQueueTestCase extends AbstractFifoQueueTestCase {

	@Override
	protected Queue createQueue() {
		return new ListFifoQueue();
	}

	
	
}
