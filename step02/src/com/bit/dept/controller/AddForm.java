package com.bit.dept.controller;

import javax.servlet.http.HttpServletRequest;

import com.bit.core.Command;

public class AddForm implements Command {

	@Override
	public String execute(HttpServletRequest req) {
		return "add";
	}
}
