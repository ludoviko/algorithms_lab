package com.algorithms.iterator;

import com.algorithms.exception.IteratorOutOfBoundsException;

public interface Iterator {
   public void last();
   public void first();
   public boolean isDone();
   public boolean hasNext();
   public void next();
   public void previous();
   public Object current() throws IteratorOutOfBoundsException;
}
