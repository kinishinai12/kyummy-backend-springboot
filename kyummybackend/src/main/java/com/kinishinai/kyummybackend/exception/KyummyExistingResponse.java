package com.kinishinai.kyummybackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FOUND)
public class KyummyExistingResponse extends RuntimeException{
	public KyummyExistingResponse(String arg0) {
		super(arg0);
	}
}
