package com.spring.aop.test.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.spring.aop.test.annotation.Logger;

@Component
public class SimpleService {
	@Value("${name:World}")
	private String name;

	@Logger
	public String getHelloMessage() {
		return "Hello " + this.name;
	}
}
