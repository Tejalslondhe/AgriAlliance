package com.app.custom_exception;

public class InvalidCredentialsException extends RuntimeException{
	
	public InvalidCredentialsException(String msg)
	{
		super(msg);
	}

}
