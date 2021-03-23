package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.DeptDao;

public class ListController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		DeptDao dao=new DeptDao();
		req.setAttribute("list", dao.selectAll());
		return "dept/list";
	}

}
