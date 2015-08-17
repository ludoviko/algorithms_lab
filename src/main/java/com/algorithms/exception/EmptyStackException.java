package com.algorithms.exception;

public class EmptyStackException extends RuntimeException {

	public EmptyStackException(String arg) {
		super(arg);
	}

	public EmptyStackException() {
		super();
	}

}
