package com.trung.goodstore.util.exception;

public class PagingException extends RuntimeException {
	public static final long serialVersionUID = 123442342343299911L;

	public PagingException() {
		super();

	}

	public PagingException(String message, Throwable cause) {
		super(message, cause);

	}

	public PagingException(String message) {
		super(message);

	}

	public PagingException(Throwable cause) {
		super(cause);

	}
}
