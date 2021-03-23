package com.bit.core;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.controller.IndexController;
import com.bit.dept.controller.AddDept;
import com.bit.dept.controller.AddForm;
import com.bit.dept.controller.DeptList;

public class FrontController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDo(req,resp);
	}
	
	protected void doDo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri=req.getRequestURI();
		uri=uri.substring(req.getContextPath().length());
		System.out.println(uri);// /step02
		
		Command controller=null;
		if(uri.equals("/")) {
			controller=new IndexController();
		}else if(uri.equals("/index.bit")) {
			controller=new IndexController();
		}else if(uri.equals("/list.bit")) {
			controller=new DeptList();
		}else if(uri.equals("/add.bit")) {
			controller=new AddForm();
		}else if(uri.equals("/insert.bit")) {
			controller=new AddDept();
		}
		
		String viewName=controller.execute(req);
		if(viewName.startsWith("redirect:")) {
			resp.sendRedirect(viewName.substring("redirect:".length()));
		}else {
			RequestDispatcher rd;
			rd=req.getRequestDispatcher("/WEB-INF/views/"
					+viewName+".jsp");
			rd.forward(req, resp);			
		}
	}
}












