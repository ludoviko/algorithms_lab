package com.algorithms.list;


import com.algorithms.iterator.Iterable;

public interface List extends Iterable {

	// Core methods
	public void insertAt(int index, Object object) throws IndexOutOfBoundsException;
	public Object delete(int index ) throws IndexOutOfBoundsException;
	public Object getAt(int index ) throws IndexOutOfBoundsException;
    public int size();
    
    // Convenience methods
	public Object setAt(int index, Object object) throws IndexOutOfBoundsException;
	// Add to the end of the list
	public void add(Object object);
	public boolean delete(Object object );
	public boolean contains(Object object );
	public int indexOf(Object object );
	public boolean isEmpty();
	public boolean hasMore();
    public void clear();
    
	
}
