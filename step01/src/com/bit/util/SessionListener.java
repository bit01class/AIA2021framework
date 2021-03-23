package com.bit.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("create: "+event.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("destroy: "+event.getSession().getId());
	}

}
