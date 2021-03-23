package com.bit.dept.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;
import com.bit.framework.Controller;

public class InsertController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		
		try {
			DeptDao dao=new DeptDao();
			dao.insertOne(new DeptVo(
					Integer.parseInt(req.getParameter("deptno"))
					,req.getParameter("dname")
					,req.getParameter("loc")
					));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "redirect:list.bit";
	}

}
