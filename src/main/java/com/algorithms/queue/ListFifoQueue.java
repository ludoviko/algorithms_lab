package com.algorithms.queue;

import java.util.ArrayList;
import java.util.List;

import com.algorithms.exception.EmptyQueueException;


/**
 * A First-In-First-Out (FIFO) {@link Queue} that uses a {@link List} internally.
 *
 */
public class ListFifoQueue implements Queue {
    /** The underlying list. */
    private final List _list;

    /**
     * Default constructor. Uses a {@link LinkedList} as the underlying list.
     */
    public ListFifoQueue() {
        this(new ArrayList());
    }

    /**
     * Constructor.
     *
     * @param list The underlying list.
     */
    public ListFifoQueue(List list) {
        _list = list;
    }

    public void enqueue(Object value) {
        _list.add(value);
    }

    public Object dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return _list.remove(0);
    }

    public void clear() {
        _list.clear();
    }

    public int size() {
        return _list.size();
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }
}
