package com.trung.goodstore.persistence.exception;

public class DaoException extends RuntimeException {
public static final long serialVersionUID=1234567890441L;
	public DaoException() {
		super();
	
	}

	public DaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public DaoException(String arg0) {
		super(arg0);
		
	}

	public DaoException(Throwable arg0) {
		super(arg0);
	
	}

}
