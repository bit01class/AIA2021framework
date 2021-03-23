package com.bit.i2.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Ex05Action extends ActionSupport {
	int deptno;
	String dname,loc;
	
	@Override
	public void validate() {
	
		if(deptno==0)
			addFieldError("deptno", "empty deptno");
		if(dname.isEmpty()) 
			addFieldError("dname", "empty dname");
		if(loc.isEmpty())
			addFieldError("loc", "empty loc");
		if(!(loc.equals("서울")
				||loc.equals("대전")
				||loc.equals("대구")
				||loc.equals("부산")
			)
		)
			addFieldError("loc", "서울대전대구부산 중 선택");
	}

	@Override
	public String execute() throws Exception {
		if(hasErrors()) return Action.INPUT;
		return Action.SUCCESS;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
