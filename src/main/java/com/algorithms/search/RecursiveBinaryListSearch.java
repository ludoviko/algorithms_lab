package com.algorithms.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.algorithms.sortStd.comparator.NaturalComparator;

public class RecursiveBinaryListSearch<T> implements ListSearcher<T> {
	private final Comparator<T> comparator;

	public RecursiveBinaryListSearch(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public int search(List<T> list, T key) {
		return this.search(list, key, 0, list.size() - 1);
	}

	public int search(List<T> list, T key, int lower, int upper) {
		int index = (upper - lower) / 2 + lower;

		if (lower > upper) {
			index = -(lower + 1);
		} else {
			if (this.comparator.compare(key, list.get(index)) > 0) {
				index = this.search(list, key, index + 1, upper);
			} else if (this.comparator.compare(key, list.get(index)) < 0) {
				index = this.search(list, key, lower, index - 1);
			} else {
				// Match
			}
		}
		return index;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RecursiveBinaryListSearch<String> listSearch = new RecursiveBinaryListSearch<String>(
				(Comparator<String>) NaturalComparator.INSTANCE);

		List<String> list = new ArrayList<String>();
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("J");
		list.add("K");
		list.add("M");
		list.add("N");
		int data = listSearch.search(list, "Z");

		System.out.println(data);
	}
}
