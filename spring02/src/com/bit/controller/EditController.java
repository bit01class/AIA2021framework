package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.model.DeptDao;
import com.bit.model.entity.DeptVo;

public class EditController implements Controller {
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
		dao.updateOne(bean);
		mav.setViewName("redirect:dept.do?idx="+bean.getDeptno());
		return mav;
	}

}
