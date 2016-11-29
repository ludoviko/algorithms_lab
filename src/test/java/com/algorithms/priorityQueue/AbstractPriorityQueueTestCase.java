package com.algorithms.priorityQueue;

import java.util.Comparator;
//import java.util.Queue;
import com.algorithms.queue.Queue;
import com.algorithms.exception.EmptyQueueException;
import com.algorithms.sortStd.comparator.NaturalComparator;
import com.algorithms.sortStd.comparator.ReverseComparator;

import junit.framework.TestCase;

/**
 * Abstract base class for testing implementations of LIFO { com.wrox.algorithms.queues.Queue}s.
 *
 */
public abstract class AbstractPriorityQueueTestCase extends TestCase {
    private static final String VALUE_A = "A";
    private static final String VALUE_B = "B";
    private static final String VALUE_C = "C";
    private static final String VALUE_D = "D";
    private static final String VALUE_E = "E";

    private Queue<String> _queue;

    protected void setUp() throws Exception {
        super.setUp();
        _queue = createQueue((Comparator<String>) NaturalComparator.INSTANCE);
    }

    protected void tearDown() throws Exception {
        _queue = null;

        super.tearDown();
    }

    protected abstract Queue<String> createQueue(Comparator<String> comparator);

    public void testAccessAnEmptyQueue() {
        assertEquals(0, _queue.size());
        assertTrue(_queue.isEmpty());

        try {
            _queue.dequeue();
            fail();
        } catch (EmptyQueueException e) {
            // expected
        }
    }

    public void testEnqueueDequeue() {
        _queue.enqueue(VALUE_B);
        _queue.enqueue(VALUE_D);
        _queue.enqueue(VALUE_A);

        assertEquals(3, _queue.size());
        assertFalse(_queue.isEmpty());

        assertSame(VALUE_D, _queue.dequeue());
        assertEquals(2, _queue.size());
        assertFalse(_queue.isEmpty());

        assertSame(VALUE_B, _queue.dequeue());
        assertEquals(1, _queue.size());
        assertFalse(_queue.isEmpty());

        _queue.enqueue(VALUE_E);
        _queue.enqueue(VALUE_C);

        assertEquals(3, _queue.size());
        assertFalse(_queue.isEmpty());

        assertSame(VALUE_E, _queue.dequeue());
        assertEquals(2, _queue.size());
        assertFalse(_queue.isEmpty());

        assertSame(VALUE_C, _queue.dequeue());
        assertEquals(1, _queue.size());
        assertFalse(_queue.isEmpty());

        assertSame(VALUE_A, _queue.dequeue());
        assertEquals(0, _queue.size());
        assertTrue(_queue.isEmpty());
    }

    public void testClear() {
        _queue.enqueue(VALUE_A);
        _queue.enqueue(VALUE_B);
        _queue.enqueue(VALUE_C);

        assertFalse(_queue.isEmpty());

        _queue.clear();

        assertTrue(_queue.isEmpty());
    }
}
