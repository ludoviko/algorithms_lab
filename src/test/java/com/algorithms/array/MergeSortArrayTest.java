package com.algorithms.array;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by UC187029 on 08/03/2016.
 */
public class MergeSortArrayTest {
    MergeSortArray mergeSortArray;

    @Before
    public void setUp() {
        mergeSortArray = new MergeSortArray<String>();
    }

    @After
    public void tearDown()  {
        mergeSortArray = null;
    }


    @Test
    public void testSort() {
        Integer[] data =     { 9, 0, 1, 8, 7, 5, 2, 4, 3, 6};
        Integer[] expected = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        mergeSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));

    }

    @Test
    public void testSort2() {
        Integer[] data = {0};
        Integer[] expected = {0};

        mergeSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }

    @Test
    public void testSort3() {
        Integer[] data = {9 , 8, 9 ,8};
        Integer[] expected = {8, 8, 9, 9};

        mergeSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }


    @Test
    public void testSort4() {
        String[] data = {"Varsovia", "Caracas", "London", "Barcelona"};
        String[] expected =  {"Barcelona", "Caracas", "London", "Varsovia" };

        mergeSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }

    @Test
    public void testSort5() {
        Integer[] data = {9, 0};
        Integer[] expected = {0, 9};

        mergeSortArray.sort(data);
        Assert.assertThat("Should be the same.", data, CoreMatchers.is(expected));
    }

}
