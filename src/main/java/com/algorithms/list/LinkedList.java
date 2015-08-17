package com.algorithms.list;

import com.algorithms.exception.IteratorOutOfBoundsException;
import com.algorithms.iterator.Iterator;


/**
 * A {@link List} implementation that stores elements in a doubly linked list.
 *
 */
public class LinkedList extends AbstractList {
    /** The sentinel pointing to the first and last elements of the list. */
    private final Element _headAndTail = new Element(null);

    /** The size of the list. */
    private int _size;

    /**
     * Default constructor.
     */
    public LinkedList() {
        this.clear();
    }

    public void insertAt(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";

        if (index < 0 || index > this._size) {
            throw new IndexOutOfBoundsException();
        }

        Element element = new Element(value);
        element.attachBefore(this.getElement(index));
        ++this._size;
    }

    public Object delete(int index) throws IndexOutOfBoundsException {
        this.checkOutOfBounds(index);
        Element element = this.getElement(index);
        element.detach();
        --this._size;
        return element.getValue();
    }

    public boolean delete(Object value) {
        assert value != null : "value can't be null";

        for (Element e = this._headAndTail.getNext(); e != this._headAndTail; e = e.getNext()) {
            if (value.equals(e.getValue())) {
                e.detach();
                --this._size;
                return true;
            }
        }

        return false;
    }

    public void add(Object value) {
        this.insertAt(this.size(), value);
    }

    public boolean contains(Object value) {
        return this.indexOf(value) != -1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        this._headAndTail.setPrevious(this._headAndTail);
        this._headAndTail.setNext(this._headAndTail);
        this._size = 0;
    }

    public Object setAt(int index, Object value) throws IndexOutOfBoundsException {
        assert value != null : "value can't be null";
        this.checkOutOfBounds(index);
        Element element = this.getElement(index);
        Object oldValue = element.getValue();
        element.setValue(value);
        return oldValue;
    }

    public Object getAt(int index) throws IndexOutOfBoundsException {
        this.checkOutOfBounds(index);
        return this.getElement(index).getValue();
    }

    public Iterator iterator() {
        return new ValueIterator();
    }

    public int indexOf(Object value) {
        assert value != null : "value can't be null";

        int index = 0;

        for (Element e = this._headAndTail.getNext(); e != this._headAndTail; e = e.getNext()) {
            if (value.equals(e.getValue())) {
                return index;
            }

            ++index;
        }

        return -1;
    }

    public int size() {
        return this._size;
    }

    /**
     * Obtains the element for a specified position.
     *
     * @param index The position (0, 1, 2...) for the desired element.
     * @return The element corresponding to the specified position.
     */
    private Element getElement(int index) {
        if (index < this._size / 2) {
            return this.getElementForwards(index);
        } else {
            return this.getElementBackwards(index);
        }
    }

    /**
     * Obtains the element for a specified position starting at the first element and working forwards.
     *
     * @param index The position (0, 1, 2...) for the desired element.
     * @return The element corresponding to the specified position.
     */
    private Element getElementForwards(int index) {
        Element element = this._headAndTail.getNext();

        for (int i = index; i > 0; --i) {
            element = element.getNext();
        }

        return element;
    }

    /**
     * Obtains the element for a specified position starting at the last element and working backwards.
     *
     * @param index The position (0, 1, 2...) for the desired element.
     * @return The element corresponding to the specified position.
     */
    private Element getElementBackwards(int index) {
        Element element = this._headAndTail;

        for (int i = this._size - index; i > 0; --i) {
            element = element.getPrevious();
        }

        return element;
    }

    /**
     * Checks if a specified position is outside the bounds of the list.
     *
     * @param index The index to check.
     * @throws IndexOutOfBoundsException if the specified index is outside the bounds of the list.
     */
    private void checkOutOfBounds(int index) {
        if (this.isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Determines if the specified index is outside the bounds of the list.
     *
     * @param index The index to check.
     * @return <code>true</code> if outside the bounds; otherwise <code>false</code>.
     */
    private boolean isOutOfBounds(int index) {
        return index < 0 || index >= this.size();
    }

    /**
     * Holds each contained value plus a reference to the next and previous elements.
     */
    private static final class Element {
        private Object _value;
        private Element _previous;
        private Element _next;

        public Element(Object value) {
            this.setValue(value);
        }

        public void setValue(Object value) {
            this._value = value;
        }

        public Object getValue() {
            return this._value;
        }

        public Element getPrevious() {
            return this._previous;
        }

        public void setPrevious(Element previous) {
            assert previous != null : "previous can't be null";
            this._previous = previous;
        }

        public Element getNext() {
            return this._next;
        }

        public void setNext(Element next) {
            assert next != null : "next can't be null";
            this._next = next;
        }

        public void attachBefore(Element next) {
            assert next != null : "next can't be null";

            Element previous = next.getPrevious();

            this.setNext(next);
            this.setPrevious(previous);

            next.setPrevious(this);
            previous.setNext(this);
        }

        public void detach() {
            this._previous.setNext(this._next);
            this._next.setPrevious(this._previous);
        }
    }

    /**
     * Iterator over the values in the list.
     */
    private final class ValueIterator implements Iterator {
        private Element _current = LinkedList.this._headAndTail;

        public void first() {
            this._current = LinkedList.this._headAndTail.getNext();
        }

        public void last() {
            this._current = LinkedList.this._headAndTail.getPrevious();
        }

        public boolean isDone() {
            return this._current == LinkedList.this._headAndTail;
        }

        public void next() {
            this._current = this._current.getNext();
        }

        public void previous() {
            this._current = this._current.getPrevious();
        }

        public Object current() throws IteratorOutOfBoundsException {
            if (this.isDone()) {
                throw new IteratorOutOfBoundsException();
            }
            return this._current.getValue();
        }

		
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return ! this.isDone();
		}
    }


	
	public boolean hasMore() {
		return ! this.isEmpty();
	}
}
