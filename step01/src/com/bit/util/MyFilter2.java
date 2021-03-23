package com.bit.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter2 implements Filter {

	@Override
	public void destroy() {
		System.out.println("------------dest---------");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("------------before---------");
		HttpServletRequest req=(HttpServletRequest) request;
		
		req.getSession();
		if(false)chain.doFilter(request, response);
		else {
			PrintWriter out = response.getWriter();
			out.println("<h1>로그인하고 오세요</h1>");
			
		}
		System.out.println("------------after---------");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("------------init---------");
	}

}
