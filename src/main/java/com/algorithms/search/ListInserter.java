package com.algorithms.search;

import java.util.List;

public class ListInserter<T> {
	private final ListSearcher<T> searcher;

	public ListInserter(ListSearcher<T> searcher) {
		this.searcher = searcher;
	}

	public int insert(List<T> list, T t) {
		int index = searcher.search(list, t);

		if (index >= 0) {
		} else {
			index = -1 - index;
		}

		list.add(index, t);
		return index;
	}
}
