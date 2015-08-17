package com.lam.coursera.princeton.algorithms.bag;

public interface Bag_I<T> extends Iterable<T>  {
	
  public void add(T t );
  public int size();
  public boolean isEmpty();
  public void clear();
  
}
