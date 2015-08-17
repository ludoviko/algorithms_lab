package com.algorithms.search;

import java.util.List;

public interface ListSearcher<T> {
	public int search(List<T> list, T key);
}
