package com.fastfood.security;

public class HashGenerationException extends Exception {

	private static final long serialVersionUID = -2763736711619547813L;
	
	
	public HashGenerationException() {
		super();
	}
	
	public HashGenerationException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public HashGenerationException(String message) {
		super(message);
	}
	
	public HashGenerationException(Throwable throwable) {
		super(throwable);
	}
	

}
