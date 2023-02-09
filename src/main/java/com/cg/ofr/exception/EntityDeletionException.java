package com.cg.ofr.exception;

public class EntityDeletionException  extends RuntimeException{

	 private String msg;

		public EntityDeletionException(String msg) {
			super();
			this.msg = msg;
		}
}
