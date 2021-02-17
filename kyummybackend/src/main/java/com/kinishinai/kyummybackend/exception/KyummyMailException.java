package com.kinishinai.kyummybackend.exception;

public class KyummyMailException extends RuntimeException {
	public KyummyMailException(String exMessage, Exception exception) {
		super(exMessage, exception);
	}
	
	public KyummyMailException(String exMessage) {
		super(exMessage);
	}
	
}
