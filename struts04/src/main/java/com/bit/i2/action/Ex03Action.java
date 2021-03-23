package com.bit.i2.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Validateable;
import com.opensymphony.xwork2.ValidationAwareSupport;

public class Ex03Action implements Action,Validateable{
	int deptno;
	String dname,loc;
	ValidationAwareSupport errs =new ValidationAwareSupport();
	
	@Override
	public void validate() {
		if(dname.equals("")) {
			errs.addFieldError("dname", "비었음1");
			errs.addFieldError("dname", "비었음2");
		}
		if(loc.equals("")) {
			errs.addFieldError("loc", "비었음");
		}
		Map<String,List<String>> map=errs.getFieldErrors();
		Set<String> keys=map.keySet();
		for(String key: keys) {
			List<String> list=map.get(key);
			for(int i=0; i<list.size(); i++)
				System.out.println(list.get(i));
		}
	}

	@Override
	public String execute() throws Exception {
		if(errs.hasErrors())return Action.INPUT;
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

	public ValidationAwareSupport getErrs() {
		return errs;
	}
}









