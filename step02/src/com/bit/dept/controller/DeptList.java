package com.bit.dept.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.core.Command;
import com.bit.dept.model.DeptDao;

public class DeptList implements Command{

	@Override
	public String execute(HttpServletRequest req) {
		DeptDao dao=new DeptDao();
		req.setAttribute("list", dao.getList());
		
		return "list";
	}
}







