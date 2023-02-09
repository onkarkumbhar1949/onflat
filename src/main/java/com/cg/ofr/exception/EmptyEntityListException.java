package com.cg.ofr.exception;

public class EmptyEntityListException extends RuntimeException {

	private String msg;

	public EmptyEntityListException(String msg) {
		super();
		this.msg = msg;
	}
}
