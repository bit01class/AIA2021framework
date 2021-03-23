package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.DeptDao;
import com.bit.model.DeptDao01;
import com.bit.model.DeptDao02;

public class ListController implements Controller {
	DeptDao dao;
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav=new ModelAndView();
		mav.addObject("list", dao.selectAll());
		mav.setViewName("list");
		return mav;
	}

}












