package com.bit.dept.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.core.Command;
import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;

public class AddDept implements Command {

	@Override
	public String execute(HttpServletRequest req) {
		DeptDao dao=new DeptDao();
		dao.insertOne(new DeptVo(
				Integer.parseInt(req.getParameter("deptno"))
				,req.getParameter("dname")
				,req.getParameter("loc")
				));
		return "redirect:list.bit";
	}

}
