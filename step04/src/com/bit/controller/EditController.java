package com.bit.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;
import com.bit.model.DeptDao;
import com.bit.model.entity.DeptVo;

public class EditController implements Controller {

	@Override
	public String execute(HttpServletRequest req) throws Exception {
		int deptno=Integer.parseInt(req.getParameter("deptno"));
		String dname=req.getParameter("dname");
		String loc=req.getParameter("loc");
		DeptVo bean=new DeptVo(deptno,dname,loc);
		
		DeptDao dao=new DeptDao();
		if(dao.updateOne(bean)>0) {
			return "redirect:detail.bit?alert=success&idx="+deptno;
		}
		return  "redirect:detail.bit?alert=danger&idx="+deptno;
	}

}










