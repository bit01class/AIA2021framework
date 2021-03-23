package com.bit.dept.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;

public class AddController implements Controller {
	DeptDao deptDao;
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		if(request.getMethod().equals("POST")) {
			DeptVo bean=new DeptVo(
					Integer.parseInt(
							request.getParameter("deptno"))
					,request.getParameter("dname")
					,request.getParameter("loc")
					);
			deptDao.insertOne(bean);
		}
		return new ModelAndView("redirect:deptlist.do");
	}

}








