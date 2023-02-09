package com.cg.ofr.exception;

public class EntityUpdationException  extends RuntimeException{

	 private String msg;

		public EntityUpdationException(String msg) {
			super();
			this.msg = msg;
		}
}
