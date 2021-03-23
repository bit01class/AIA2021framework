package com.bit.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("Listener destroy...");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("Listener initial...");
	}

}
