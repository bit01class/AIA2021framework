package com.bit.sts05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeptAop {
	Logger log=LoggerFactory.getLogger(DeptAop.class);

	public void before(JoinPoint jp) {
		log.debug("before...");
		log.debug(Arrays.toString(jp.getArgs()));
	}
	
	public void after(JoinPoint jp) {
		log.debug("after...");
	}
	
	public void afterReturn(JoinPoint jp,Object obj) {
		log.debug("after success...");
	}
	
	public void afterErr(JoinPoint jp, Exception ex) {
		log.debug("after fail..");
	}
	
	public void around(ProceedingJoinPoint joinPoint){
		log.debug("around before...");
		try {
			joinPoint.proceed();
			log.debug("around afterReturning...");
		} catch (Throwable e) {
			log.debug("around afterThrow...");
		}
		log.debug("around after...");
	}
}
