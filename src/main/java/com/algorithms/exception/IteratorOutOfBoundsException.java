package com.algorithms.exception;

public class IteratorOutOfBoundsException extends RuntimeException {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IteratorOutOfBoundsException(String string) {
    	super(string); 
     }; 

     public IteratorOutOfBoundsException() {
     	this("El iterador ha sobrepasado sus límites"); 
      }; 


}
