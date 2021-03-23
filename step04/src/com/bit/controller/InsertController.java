package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.DeptDao;
import com.bit.model.entity.DeptVo;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		DeptVo bean=new DeptVo(
				Integer.parseInt(req.getParameter("deptno"))
				,req.getParameter("dname")
				,req.getParameter("loc")
				);
		DeptDao dao=new DeptDao();
		dao.insertOne(bean);
		return "redirect:list.bit";
	}

}
