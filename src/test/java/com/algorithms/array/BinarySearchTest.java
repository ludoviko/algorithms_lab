package com.algorithms.array;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
    BinarySearch search;

    @Before
    public void setUp() {
        search = new BinarySearch();
    }

    @After
    public void tearDown()  {
        search = null;
    }

    @Test
    public void testAssertDataMatch() {
          search.setData(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811);
          Assert.assertThat("Should be the same.", search.search(144), CoreMatchers.is(10));
    }

    @Test
    public void testAssertDataMatch_2() {
        search.setData(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811);
        Assert.assertThat("Should be the same.", search.search(1), CoreMatchers.is(0));
    }

    @Test
    public void testAssertDataMatch_3() {
        search.setData(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811);
        Assert.assertThat("Should be the same.", search.search(317811), CoreMatchers.is(26));
    }

    @Test
    public void testAssertDataMatch_4() {
        search.setData(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811);
        Assert.assertThat("Should be the same.", search.search(46368), CoreMatchers.is(22));
    }

    @Test
    public void testAssertDataMatch_5() {
        search.setData(1);
        Assert.assertThat("Should be the same.", search.search(1), CoreMatchers.is(0));
    }


    @Test
    public void testAssertDataNoMatch() {
        search.setData(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811);
        Assert.assertThat(search.search(157), CoreMatchers.is(-1));
    }

    @Test
    public void testAssertDataNoMatch_2() {
        search.setData(1);
        Assert.assertThat(search.search(157), CoreMatchers.is(-1));
    }

}

