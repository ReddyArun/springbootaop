package com.spring.aop.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.spring.aop.test.service.SimpleService;

@EnableAutoConfiguration
@ComponentScan
public class SimpleSpringAOP implements CommandLineRunner {

	@Autowired
	private SimpleService ss;

	@Override
	public void run(String... arg0) throws Exception {
		System.out.println(this.ss.getHelloMessage());
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringAOP.class, args);
	}
}
