package com.bit.dept.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.framework.Controller;

public class IndexController implements Controller {

	@Override
	public String execute(HttpServletRequest req) {
		return "index";
	}

}
