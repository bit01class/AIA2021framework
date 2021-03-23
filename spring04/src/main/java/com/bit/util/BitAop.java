package com.bit.util;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class BitAop implements MethodBeforeAdvice {

//	public void execute() {
//		System.out.println("공통관심사"+System.currentTimeMillis());
//	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("공통관심사"+System.currentTimeMillis());
	}
}
