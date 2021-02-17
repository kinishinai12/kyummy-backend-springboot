package com.kinishinai.kyummybackend.service;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

	private final TemplateEngine TEMPLATEENGINE;

	
	public MailContentBuilder(TemplateEngine tEMPLATEENGINE) {
		super();
		TEMPLATEENGINE = tEMPLATEENGINE;
	}

	public TemplateEngine getTEMPLATEENGINE() {
		return TEMPLATEENGINE;
	}


	String build(String message) {
		Context context = new Context();
		context.setVariable("message", message);
		return TEMPLATEENGINE.process("mailTemplaate", context);
		
	}
	
}
