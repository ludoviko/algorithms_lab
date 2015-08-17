package com.algorithms.sortStd;

import java.util.Comparator;
import java.util.List;

public class QuickSortListSorter implements ListSorter {

	private final Comparator<Object> comparator;

	public QuickSortListSorter(Comparator<Object> comparator) {
		this.comparator = comparator;
	}

	public List sort(List list) {
		quickSort(0, list.size() - 1, list);
		return list;
	}

	private void quickSort(int left, int right, List list) {

		if (left < 0 || right >= list.size() || right <= left) {
			return;
		}

		Object item = list.get(right);

		int partition = partition(left, right - 1, item, list);
		if (comparator.compare(list.get(partition), item) < 0) {
			++partition;
		}

		swap(partition, right, list);

		quickSort(left, partition - 1, list);
		quickSort(partition + 1, right, list);

	}

	private int partition(int left, int right, Object item, List list) {

		while (left < right) {
			if (comparator.compare(list.get(left), item) < 0) {
				left++;
				continue;
			}

			if (comparator.compare(list.get(right), item) >= 0) {
				right--;
				continue;
			}

			swap(right, left, list);
			left++;
		}

		return left;
	}

	private void swap(int right, int left, List list) {
		Object aux = list.get(left);
		list.set(left, list.get(right));
		list.set(right, aux);
	}

}