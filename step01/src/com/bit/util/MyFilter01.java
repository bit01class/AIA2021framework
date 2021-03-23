package com.bit.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


//@WebFilter("/*")
public class MyFilter01 implements Filter {
	String val;

	@Override
	public void destroy() {
		System.out.println("destroy...");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("before..."+val);
		chain.doFilter(arg0, arg1);
		System.out.println("after...");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init...");
		val=config.getInitParameter("name1");
	}

}





