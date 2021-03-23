package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.core.Command;

public class IndexController implements Command{

	@Override
	public String execute(HttpServletRequest req) {
		return "index";
	}
}









