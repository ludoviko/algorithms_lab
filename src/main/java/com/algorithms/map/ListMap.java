package com.algorithms.map;

import com.algorithms.iterator.Iterator;
import com.algorithms.list.LinkedList;
import com.algorithms.list.List;

public class ListMap implements Map {
	private List entries;

	public ListMap() {
		this.entries = new LinkedList();
	}

	
	public Object get(Object key) {
		DefaultEntry entry = this.search(key);

		if (entry != null) {
			return entry.getValue();
		}

		return null;
	}

	
	public Object set(Object key, Object value) {
		DefaultEntry entry = this.search(key);

		if (entry != null) {
			return entry.setValue(value);
		} else {
			this.entries.add(new DefaultEntry(key, value));
		}
		return entry;
	}

	
	public Object delete(Object key) {
		DefaultEntry entry = this.search(key);

		if (entry == null) {
			return null;
		}

		this.entries.delete(entry);

		return entry.getValue();
	}

	
	public Iterator iterator() {
		return this.entries.iterator();
	}

	
	public boolean contains(Object key) {
		return this.search(key) != null;
	}

	
	public void clear() {
		this.entries.clear();
	}

	
	public int size() {
		return this.entries.size();
	}

	
	public boolean isEmpty() {
		return this.entries.isEmpty();
	}

	private DefaultEntry search(Object key) {
		Iterator i = this.iterator();
		for (i.first(); !i.isDone(); i.next()) {
			DefaultEntry entry = (DefaultEntry) i.current();
			if (entry.getKey().equals(key)) {
				return entry;
			}
		}

		return null;
	}
}
