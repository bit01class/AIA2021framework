package com.bit.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;

public class BitAfterExceptionMethod implements ThrowsAdvice {
	Logger log=Logger.getLogger(this.getClass());

//	public void afterThrowing(Exception ex) {
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
		log.debug(method.getName());
		log.debug(ex.getClass());
	}
}
