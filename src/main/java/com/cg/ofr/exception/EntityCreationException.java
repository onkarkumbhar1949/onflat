package com.cg.ofr.exception;

public class EntityCreationException  extends RuntimeException{

	 private String msg;

	public EntityCreationException(String msg) {
		super();
		this.msg = msg;
	}
}
