package com.bit.action;

import com.bit.dept.model.DeptDao;
import com.opensymphony.xwork2.Action;

public class EditDeptAction implements Action {
	int deptno;
	String dname,loc;
	
	public int getDeptno() {
		return deptno;
	}
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
		DeptDao dao=new DeptDao();
		dao.updateOne(deptno, dname, loc);
		return Action.SUCCESS;
	}

}







