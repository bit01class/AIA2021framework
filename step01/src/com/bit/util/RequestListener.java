package com.bit.util;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("destroy...");
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("init...");
		HttpServletRequest req = (HttpServletRequest)event.getServletRequest();
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
