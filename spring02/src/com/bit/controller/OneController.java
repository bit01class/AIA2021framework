package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.DeptDao;

public class OneController implements Controller {
	DeptDao dao;
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		int deptno=Integer.parseInt(request.getParameter("idx"));
		mav.addObject("bean", dao.selectOne(deptno));
		mav.setViewName("detail");
		return mav;
	}

}
