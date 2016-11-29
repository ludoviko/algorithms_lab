package com.algorithms.array;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by UC187029 on 08/03/2016.
 */
public class SelectionSortArrayTest {
    SelectionSortArray selectionSortArray;

    @Before
    public void setUp() {
        selectionSortArray = new SelectionSortArray();
    }

    @After
    public void tearDown()  {
        selectionSortArray = null;
    }

    @Test
    public void testSearchMinimum() {
        Integer[] data = {9, 0, 1,  8, 7, 5, 2, 4, 3, 6};
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 0), CoreMatchers.is(1));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 1), CoreMatchers.is(1));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 2), CoreMatchers.is(2));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 3), CoreMatchers.is(6));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 4), CoreMatchers.is(6));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 5), CoreMatchers.is(6));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 6), CoreMatchers.is(6));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 7), CoreMatchers.is(8));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 8), CoreMatchers.is(8));
        Assert.assertThat("Should be the same.", selectionSortArray.minimum(data, 9), CoreMatchers.is(9));
    }

    @Test
    public void testSwap() {
        Integer[] data = {9, 0, 1,  8, 7, 5, 2, 4, 3, 6};
        Integer[] expected;

        selectionSortArray.swap(data, 0, 1);
        expected = new Integer[] {0, 9, 1,  8, 7, 5, 2, 4, 3, 6};
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));

        selectionSortArray.swap(data, 0, data.length - 1);
        expected = new Integer[] {6, 9, 1,  8, 7, 5, 2, 4, 3, 0};
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));

        selectionSortArray.swap(data, 1, 2);
        expected = new Integer[] {6, 1, 9,  8, 7, 5, 2, 4, 3, 0};
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }

    @Test
    public void testSort() {
        Integer[] data = {9, 0, 1, 8, 7, 5, 2, 4, 3, 6};
        Integer[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        selectionSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));

    }

    @Test
    public void testSort2() {
        Integer[] data = {0};
        Integer[] expected = {0};

        selectionSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }

    @Test
    public void testSort3() {
        Integer[] data = {9 , 8, 9 ,8};
        Integer[] expected = {8, 8, 9, 9};

        selectionSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }


    @Test
    public void testSort4() {
        String[] data = {"Caracas", "London", "Barcelona"};
        String[] expected =  {"Barcelona", "Caracas", "London" };

        selectionSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }

}
