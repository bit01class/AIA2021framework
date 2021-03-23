package com.bit.i2.action;

import com.opensymphony.xwork2.Action;

public class Ex01Action implements Action {
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
		System.out.println("deptno:"+deptno);
		System.out.println("dname:"+dname);
		System.out.println("loc:"+loc);
		return Action.SUCCESS;
	}

}
