package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Ex02Controller extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		//System.out.println("Ex02 init...");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ex02: "+req.getSession().getId());
		System.out.println("Ex02Controller run...");
		HttpSession session = req.getSession();
		session.invalidate();
		System.out.println("ex02: "+req.getSession().getId());
	}
}







