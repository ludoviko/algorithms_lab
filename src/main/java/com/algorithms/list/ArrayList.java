package com.algorithms.list;

import com.algorithms.iterator.ArrayIterator;
import com.algorithms.iterator.Iterator;

public class ArrayList implements List {
	int size; 
	private Object[] array;
	private static final int INITIAL_CAPACITY = 4;

	private final int initialCapacity;
	
	public  ArrayList(int initialCapacity){
		this.initialCapacity = initialCapacity;
		this.clear();
	};
	
	public  ArrayList(){
		this(INITIAL_CAPACITY);
	};

	public  ArrayList(Object[] objects){
		
		this(objects.length * 2);

		System.arraycopy(objects, 0, this.array, 0, objects.length);
		this.size = objects.length;
		
	};
	
	
	
	public Iterator iterator() {
		return new ArrayIterator(this.array, 0, this.size);
	};

	
	public void insertAt(int index, Object object)
			throws IndexOutOfBoundsException {
		if ( index < 0 || index > this.size()  ) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		};
		this.checkCapacity();
        System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        this.array[index] = object;
        ++this.size;
	}

	
	
	public void add(Object object) {
		this.insertAt(this.size, object);
	}
	
	private void checkCapacity(  ) {
		if ( this.size() + 1 > this.array.length ) { 
			// copy the content of the array into a bigger one
			Object[] array_destination = new Object[this.array.length * 2];
			System.arraycopy(this.array, 0, array_destination, 0, this.size);
			this.array = array_destination;
		} else {
			// Fine
		};
	}; 

	
	public Object getAt(int index) throws IndexOutOfBoundsException {
		if ( index < 0 || index >= this.size()  ) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		};
		return this.array[index];
	}

	
	
	public Object delete(int index) throws IndexOutOfBoundsException {
		if ( index < 0 || index >= this.size()  ) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		};
		Object object = this.getAt(index);
		System.arraycopy(this.array, index + 1, this.array, index , this.size - index - 1);
        this.array[this.size - 1] = null;
        --this.size;
		return object;
	}

	
	public int size() {
		return this.size;
	}

	
	public Object setAt(int index, Object object)
			throws IndexOutOfBoundsException {
		if ( index < 0 || index >= this.size()  ) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		};
        return this.array[index] = object;
	}

	
	public boolean contains(Object object) {
		  return  this.indexOf(object) >= 0;
	};

	
	
	public int indexOf(Object object) {
	       for (int index = 0; index < this.size; index++) {
		  		 if ( this.array[index].equals( object ) ) {
		  			return index;
		  		 } else {
		  		 }
		  	  };
		  	  return -1;
	};

	
	public boolean delete(Object object) {
		// Delete the first occurrence of object
		  int index = this.indexOf(object);
		  if (index > -1) {
			  this.delete(index);
			  return true;
		  } else {
			  return false;
		  }
	};

	
	public boolean isEmpty() {
		return this.size == 0;
	}

	
	public boolean hasMore() {
		// TODO Auto-generated method stub
		return ! this.isEmpty();
	}

	
	public void clear() {
		this.array = new Object[this.initialCapacity];
		this.size = 0;
	}

}
