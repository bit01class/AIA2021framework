package com.bit.action;

import com.opensymphony.xwork2.Action;

public class Ex01Action implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("run Ex01Action...");
		return "success";
	}

}
