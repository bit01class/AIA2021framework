package com.bit.sts03.dept.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.sts03.dept.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	DeptService deptService;

	@RequestMapping("/dept/")
	public String list(Model model) {
		try {
			deptService.setModelList(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "dept/list";
	}
}


















