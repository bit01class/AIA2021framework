package com.bit.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		Module01 module=null;
		ApplicationContext context=null;
		context=new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		module=(Module01) context.getBean("proxy");
		module.func01();
		module.func02();
		module.func03();
	}

}
