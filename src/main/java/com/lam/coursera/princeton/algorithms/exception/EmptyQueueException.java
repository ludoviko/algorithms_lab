package com.lam.coursera.princeton.algorithms.exception;

public class EmptyQueueException extends RuntimeException {
	private static final long	serialVersionUID	= 1L;

	public EmptyQueueException() {
		super();
	} 

	public EmptyQueueException(String string) {
		super(string);
	} 

}
