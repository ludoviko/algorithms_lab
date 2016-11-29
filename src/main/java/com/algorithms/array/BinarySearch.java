package com.algorithms.array;

/**
 * Created by UC187029 on 27/02/2016.
 */
public class BinarySearch {

    private int[] data;

    public BinarySearch(int... data) {
        this.data = data;
    }

    public BinarySearch() {
    }

    public void  setData(int... data) {
        this.data = data;
    }

    public int search(int n) {

        int min = 0;
        int max = data.length - 1;

        int half = ( min +  max ) / 2;


        while (true) {
            if ( data[half] == n ) {
                 break;
            } else if  ( data[half] < n ) {
                 min =  half + 1;
            } else {
                max =  half - 1;
            }

            if (max < min ) {
                half = -1;
                break;
            }

            half = ( min +  max ) / 2;
        }

        return half;
    }

}
