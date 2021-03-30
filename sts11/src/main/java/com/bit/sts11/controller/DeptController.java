package com.bit.sts11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bit.sts11.model.DeptDao;

@Controller
public class DeptController {
	@Autowired
	DeptDao deptDao;

	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("list", deptDao.selectAll());
		return "index";
	}
}
