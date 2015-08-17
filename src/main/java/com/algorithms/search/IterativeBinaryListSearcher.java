package com.algorithms.search;

import java.util.Comparator;
import java.util.List;

public class IterativeBinaryListSearcher<T> implements ListSearcher<T> {
	private final Comparator<T> comparator;

	public IterativeBinaryListSearcher(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	public int search(List<T> list, T key) {
		int lower = 0, upper = list.size() - 1;
		int index;

		while (true) {
			index = (upper - lower) / 2 + lower;
			if (lower > upper) {
				index = -(lower + 1);
				break;
			} else {
				if (this.comparator.compare(key, list.get(index)) > 0) {
					lower = index + 1;
				} else if (this.comparator.compare(key, list.get(index)) < 0) {
					upper = index - 1;
				} else {
					break;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
	}

}
