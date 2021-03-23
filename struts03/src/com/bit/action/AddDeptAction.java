package com.bit.action;

import com.bit.dept.model.DeptDao;
import com.opensymphony.xwork2.Action;

public class AddDeptAction implements Action {
	int deptno;
	String dname,loc;
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String execute() throws Exception {
		if(deptno==0)return Action.INPUT;
		if(dname==null)return Action.INPUT;
		if(loc==null)return Action.INPUT;
		if(dname.isEmpty())return Action.INPUT;
		if(loc.isEmpty())return Action.INPUT;
		
		DeptDao dao=new DeptDao();
		dao.insertOne(deptno, dname, loc);
		return Action.SUCCESS;
	}

}
