package com.algorithms.array;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QuickSortArrayTest {
    QuickSortArray quickSortArray;

    @Before
    public void setUp() {
        quickSortArray = new QuickSortArray<Character>();
    }

    @After
    public void tearDown()  {
        quickSortArray = null;
    }

    @Test
    public void testSearchingPartitionElement() {
        Character[] data = {'k', 'r', 'a', 't', 'e', 'l', 'e', 'p', 'u', 'i', 'm', 'q', 'c', 'x', 'o', 's'};
        int expected = 5;

        Assert.assertThat("Should be the same.", quickSortArray.partition(data, 0, data.length -1), CoreMatchers.is(expected));
    }

    @Test
    public void testSort() {
        Integer[] data = {9, 0, 1, 8, 7, 5, 2, 4, 3, 6};
        Integer[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        quickSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));

    }

    @Test
    public void testSort2() {
        Integer[] data = {0};
        Integer[] expected = {0};

        quickSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }

    @Test
    public void testSort3() {
        Integer[] data = {9 , 8, 9 ,8};
        Integer[] expected = {8, 8, 9, 9};

        quickSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }


    @Test
    public void testSort4() {
        String[] data = {"Moscou", "Caracas", "London", "Barcelona"};
        String[] expected =  {"Barcelona", "Caracas", "London", "Moscou" };

        quickSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }


    @Test
    public void testSort5() {
        String[] data = {"Moscou", "Caracas", "London", "Barcelona", "Moscou"};
        String[] expected =  {"Barcelona", "Caracas", "London", "Moscou", "Moscou" };

        quickSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }


}

