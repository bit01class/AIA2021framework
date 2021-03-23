package com.bit.aop;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

public class BitAfterReturnMethod implements AfterReturningAdvice {
	Logger log=Logger.getLogger(this.getClass());

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		log.debug("after return..."+method.getName());
		log.debug(returnValue);
	}

}
