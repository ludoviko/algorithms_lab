package com.algorithms.iterator;

import com.algorithms.exception.IteratorOutOfBoundsException;

/**
 * An {@link Iterator} that reverses the iteration direction of another.
 *
 */
public class ReverseIterator implements Iterator {
    /** The underlying iterator. */
    private final Iterator _iterator;

    /**
     * Constructor.
     *
     * @param iterator The underlying iterator.
     */
    public ReverseIterator(Iterator iterator) {
        assert iterator != null : "iterator can't be null";
        this._iterator = iterator;
    }

    public void first() {
        this._iterator.last();
    }

    public void last() {
        this._iterator.first();
    }

    public boolean isDone() {
        return this._iterator.isDone();
    }

    public void next() {
        this._iterator.previous();
    }

    public void previous() {
        this._iterator.next();
    }

    public Object current() throws IteratorOutOfBoundsException {
        return this._iterator.current();
    }

	public boolean hasNext() {
		// TODO Auto-generated method stub
		return this._iterator.hasNext();
	}
}
