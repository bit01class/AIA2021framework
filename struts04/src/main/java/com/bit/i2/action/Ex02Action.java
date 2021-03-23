package com.bit.i2.action;

import com.bit.i2.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class Ex02Action implements Action,ModelDriven,Preparable {
	DeptVo bean;

	@Override
	public void prepare() throws Exception {
		bean=new DeptVo();
	}
	
	@Override
	public Object getModel() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(bean);
		return Action.SUCCESS;
	}

}
