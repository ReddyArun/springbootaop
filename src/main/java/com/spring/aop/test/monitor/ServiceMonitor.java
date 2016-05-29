package com.spring.aop.test.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {
	@Pointcut("execution(String get*())")
	public void allGetters() {

	}

	@Pointcut("within(com.spring.aop.test.service.*)")
	public void allGettersWithIn() {

	}

	// @Pointcut("args( arg1, arg2)")
	// public void allGettersArgs(){
	//
	// }

	@Before("allGettersWithIn() && allGetters()")
	public void logServiceAccess(JoinPoint joinpoint) {
		System.out.println("Completed: " + joinpoint.getTarget());
	}

	@Around("allGetters()")
	public Object ariundAdvice(ProceedingJoinPoint joinPoint) {
		Object returnValue = null;
		System.out.println("before method invoke log message");
		try {
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after method invoke log message");
		return returnValue;
	}

	@Around("@annotation(com.spring.aop.test.annotation.Logger)")
	public Object customAnnotation(ProceedingJoinPoint joinPoint) {
		Object returnValue = null;
		System.out.println("before customAnnotation method invoke log message");
		try {
			returnValue = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("after customAnnotation method invoke log message");
		return returnValue;
	}
}
