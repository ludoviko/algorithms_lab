package com.algorithms.sorting;

import com.algorithms.list.List;
import com.algorithms.sorting.comparator.Comparator;

/**
 * Created by Usuario on 19/02/2017.
 */
public class InsertionSortListSorter implements ListSorter_I {

    private Comparator comparator;

    public InsertionSortListSorter(Comparator comparator) {
        this.comparator = comparator;
    }


    public List sort(List list) {
        int upTo = 1;

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < upTo; j++) {
                if (this.comparator.compare(list.getAt(upTo), list.getAt(j)) > 0) {
                } else {
                    list.insertAt(j, list.getAt(upTo));
                    list.delete(upTo +1);
                }
            }
            upTo++;
        }

        return list;
    }
}
