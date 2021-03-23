package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.DeptDao;
import com.bit.model.DeptDao01;
import com.bit.model.DeptDao02;
import com.bit.model.entity.DeptVo;

public class AddController implements Controller {
	DeptDao dao;
	
	public void setDao(DeptDao dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav=new ModelAndView();
		DeptVo bean=new DeptVo(
				Integer.parseInt(request.getParameter("deptno"))
				,request.getParameter("dname")
				,request.getParameter("loc")
				);
		dao.insertOne(bean);
		mav.setViewName("redirect:list.do");
		return mav;
	}

}
