package org.opendata;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

// FIFO
public class ArrayQueue<T> {
    /**
     * The class of elements stored in this queue
     */
    protected Factory<T> f;

    /**
     * Array used to store elements
     */
    protected T[] data;

    /**
     * Index of next element to de-queue.
     */
    protected int j;

    /**
     * Number of elements in the queue
     */
    protected int n;

    public ArrayQueue(Class<T> t) {
        f = new Factory<T>(t);
        data = f.newArray(6);
        j = 0;
        n = 0;
    }

    /**
     * Grow the internal array
     */
    protected void resize() {
        T[] b = f.newArray(Math.max(1,n*2));
        for (int k = 0; k < n; k++)
            b[k] = this.data[(j+k) % this.data.length];
        this.data = b;
        j = 0;
    }

    protected boolean add(T x) {
        if (this.n + 1 > this.data.length) {
            this.resize();
        }

        this.data[ (this.j + this.n) % this.data.length ] = x;

        this.n++;

        return true;
    }

    protected T remove() {
        if (n==0) {
            throw new NoSuchElementException();
        }

        T x = this.data[j];
        j = (j+1)%this.data.length;
        this.n--;
        if (this.data.length >= 3 * n ) {
            this.resize();
        }

        return x;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.data);
    }

    public static void main(String[] strings) {
        ArrayQueue<Character> data = new ArrayQueue<Character>(Character.class);

        data.add('a');
        data.add('b');
        data.add('c');
        data.add('d');
        data.add('e');
        data.add('f');

        System.out.println(data);

        data.remove();
        data.remove();
        data.remove();
        System.out.println(data);

        data.add('g');
        data.add('h');
        data.add('i');
        System.out.println(data);

        System.out.println(data.remove());
        System.out.println(data.remove());
        System.out.println(data.remove());
        System.out.println(data);

    }


}
