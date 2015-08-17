package com.lam.coursera.princeton.algorithms.exception;


public class EmptyStackException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyStackException(String arg) {
		super(arg);
	}

	public EmptyStackException() {
		super();
	}

}
