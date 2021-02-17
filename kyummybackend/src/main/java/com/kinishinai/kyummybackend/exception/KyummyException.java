package com.kinishinai.kyummybackend.exception;

public class KyummyException extends RuntimeException {
	public KyummyException(String exMessage, Exception exception) {
		super(exMessage, exception);
	}
	
	public KyummyException(String exMessage) {
		super(exMessage);
	}
}
