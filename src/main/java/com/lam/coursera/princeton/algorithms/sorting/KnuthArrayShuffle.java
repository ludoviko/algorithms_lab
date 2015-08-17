package com.lam.coursera.princeton.algorithms.sorting;


public class KnuthArrayShuffle<T> implements ArrayShuffle_I<T> {
	
	@Override
	public void shuffle(T[] array) {
		int size = array.length;
		int r;
		
		for (int i = 1; i < size; i++) {
			r = (int) ((i + 1) * Math.random());
//		    System.out.println(i + "/" + r ); 	
			this.swap(array, i, r);
		}
		
		this.shuffleReverse(array);
	}

	public void shuffleReverse(T[] array) {
		int size = array.length;
		int r;
		
        int j = 1;
		for (int i = size - 1; i > 0; i--) {
			r = size - 1 - (int) ((++j) * Math.random());
	//	    System.out.println(i + "/" + r ); 	
			this.swap(array, i, r);
		}
	}
	
	protected  void swap(T[] array, int i, int j) {
		
		if (i == j) {
			return;
		}
		
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	public static void main(String[] args)  {
		int size = 10;
		Integer[] array = new Integer[size]; 
		
		for (int i = 0; i < size; i++) {
			array[i] = i;
		}

		KnuthArrayShuffle<Integer> shuffle = new KnuthArrayShuffle<Integer>();
		
		shuffle.shuffle(array);

		for (Integer i : array ) {
			System.out.print(i + " ");
		}
		
	}
}
