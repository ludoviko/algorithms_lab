package com.algorithms.sortStd;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Ludoviko Azuaje
 * 
 *         Problem Statement MergeSort is a classical sorting algorithm
 *         following the divide-and-conquer paradigm. Sorting n elements, it has
 *         a worst-case complexity of O(n*log(n)), which is optimal for sorting
 *         algorithms based on comparisons.
 * 
 * 
 * 
 *         Basically, it sorts a list with more than one element the following
 *         way (a list containing only one element is always sorted):
 * 
 *         1. divide the list into two sublists of about equal size (divide) 2.
 *         sort each of the two sublists (conquer) 3. merge the two sorted
 *         sublists into one sorted list (combine)
 * 
 * 
 * 
 *         A pro of MergeSort is that it is stable, i.e. elements with the same
 *         key value keep their relative order during sorting. A con is that it
 *         is not in-place since it needs additional space for temporarily
 *         storing elements.
 * 
 * 
 * 
 *         Given a int[] numbers, return the number of comparisons the MergeSort
 *         algorithm (as described in pseudocode below) makes in order to sort
 *         that list. In this context, a single comparison takes two numbers x,
 *         y (from the list to be sorted) and determines which of x < y, x = y
 *         and x > y holds.
 * 
 * 
 * 
 *         List mergeSort(List a)
 * 
 *         1. if size(a) <= 1, return a
 * 
 *         2. split a into two sublists b and c
 * 
 *         if size(a) = 2*k, b contains the first k elements of a, c the last k
 *         elements
 * 
 *         if size(a) = 2*k+1, b contains the first k elements of a, c the last
 *         k+1 elements
 * 
 *         3. List sb = mergeSort(b)
 * 
 *         List sc = mergeSort(c)
 * 
 *         4. return merge(sb, sc)
 * 
 * 
 * 
 *         List merge(List b, List c)
 * 
 *         1. create an empty list a
 * 
 *         2. while both b and c are not empty, compare the first elements of b
 *         and c
 * 
 *         first(b) < first(c): remove the first element of b and append it to
 *         the end of a
 * 
 *         first(b) > first(c): remove the first element of c and append it to
 *         the end of a
 * 
 *         first(b) = first(c): remove the first elements of b and c and append
 *         them to the end of a
 * 
 *         3. if either b or c is not empty, append that non-empty list to the
 *         end of a
 * 
 *         4. return a
 * 
 * 
 *         Definition
 * 
 *         Class: MergeSort Method: howManyComparisons Parameters: int[]
 *         Returns: int Method signature: int howManyComparisons(int[] numbers)
 *         (be sure your method is public)
 * 
 * 
 *         Notes - Be sure to exactly follow the algorithm as described, as a
 *         different implementation of MergeSort might lead to a different
 *         number of comparisons.
 * 
 *         Constraints - numbers contains between 0 and 50 elements, inclusive.
 *         - Each element of numbers is an int in its 'natural' (signed 32-bit)
 *         range from -(2^31) to (2^31)-1.
 * 
 *         Examples 0)
 * 
 * 
 *         {1, 2, 3, 4}
 * 
 *         Returns: 4
 * 
 *         {1, 2, 3, 4} is first split to {1, 2} and {3, 4}. {1, 2} is split to
 *         {1} and {2} and merging to {1, 2} takes one comparison. {3, 4} is
 *         split to {3} and {4} and merging to {3, 4} also takes one comparison.
 *         Merging {1, 2} and {3, 4} to {1, 2, 3, 4} takes two comparisons
 *         (first 1 is compared to 3 and then 2 is compared to 3). This makes a
 *         total of four comparisons. 1)
 * 
 * 
 *         {2, 3, 2}
 * 
 *         Returns: 2
 * 
 *         {2, 3, 2} is split to {2} and {3, 2}. {3, 2} is split and then merged
 *         to {2, 3} making one comparison. {2} and {2, 3} are merged to {2, 2,
 *         3} also making one comparison, which totals to two comparisons made.
 *         2)
 * 
 * 
 *         {-17}
 * 
 *         Returns: 0
 * 
 *         3)
 * 
 * 
 *         {}
 * 
 *         Returns: 0
 * 
 *         4)
 * 
 * 
 *         {-2000000000,2000000000,0,0,0,-2000000000,2000000000,0,0,0}
 * 
 *         Returns: 19
 * 
 *         This problem statement is the exclusive and proprietary property of
 *         TopCoder, Inc. Any unauthorized use or reproduction of this
 *         information without the prior written consent of TopCoder, Inc. is
 *         strictly prohibited. (c)2010, TopCoder, Inc. All rights reserved.
 *         
 *         This problem was used for: Single Round Match 151 Round 1 - Division
 *         I, Level Two Single Round Match 151 Round 1 - Division II, Level
 *         Three
 */


public class MergesortListSorter<T> implements ListSorter<T> {
	public static int count;
	private final Comparator<T> comparator;

	public int howManyComparisons(T[] numbers) {
		List<T> list = new ArrayList<T>();
		count = 0;

		for (T t : numbers) {
			list.add(t);
		}

		mergeSort(list);
		return count;
	}
	
    public List<T> sort(List<T> list) {
        assert list != null : "list cannot be null";

        return mergeSort(list);
    }

	public MergesortListSorter(Comparator<T> comparator) {
		this.comparator = comparator;

	}

	public MergesortListSorter() {
		comparator = new Comparator<T>() {
			public int compare(T left, T right) throws ClassCastException {
				assert left != null : "left can't be null";
				assert right != null : "right can't be null";

				return ((Comparable<T>) left).compareTo(right);
			}
		};
	}

	public int howManyComparisons(List<T> list) {
		count = 0;
		mergeSort(list);
		return count;
	}

	public List<T> mergeSort(List<T> c) {
		int k;
		int size = c.size();

		if (size <= 1) {
			return c;
		}

		if (size % 2 == 0) {
			k = size / 2;
		} else {
			k = size / 2 + 1;
		}

		List<T> a = c.subList(0, k);
		List<T> b = c.subList(k, size);

		List<T> aa = mergeSort(a);
		List<T> bb = mergeSort(b);

		return merge(aa, bb);
	}

	public List<T> merge(List<T> a, List<T> b) {
		List<T> merged = new ArrayList<T>();

		Iterator<T> iteraB = b.iterator();
		Iterator<T> iteraA = a.iterator();

		T oA;
		T oB;

		oA = iteraA.next();
		oB = iteraB.next();

		do {
			if (comparator.compare(oA, oB) < 0) {
				merged.add(oA);
				count++;
				if (iteraA.hasNext()) {
					oA = iteraA.next();
				} else {
					merged.add(oB);
					break;
				}
			} else if (comparator.compare(oA, oB) > 0) {
				merged.add(oB);
				count++;
				if (iteraB.hasNext()) {
					oB = iteraB.next();
				} else {
					merged.add(oA);
					break;
				}
			} else {
				merged.add(oA);
				merged.add(oB);
				count++;
				if (iteraA.hasNext()) {
					oA = iteraA.next();
				} else {
					break;
				}
				if (iteraB.hasNext()) {
					oB = iteraB.next();
				} else {
					break;
				}
			}
		} while (true);

		while (iteraA.hasNext()) {
			oA = iteraA.next();
			merged.add(oA);
		}
		while (iteraB.hasNext()) {
			oB = iteraB.next();
			merged.add(oB);
		}
		return merged;
	}
}
