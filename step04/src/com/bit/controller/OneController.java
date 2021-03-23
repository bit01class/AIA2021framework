package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.DeptDao;

public class OneController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		int param=Integer.parseInt(req.getParameter("idx"));
		DeptDao dao=new DeptDao();
		req.setAttribute("bean", dao.selectOne(param));
		return "dept/detail";
	}

}
