package com.bit.sts12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bit.sts12.model.entity.DeptVo;
import com.bit.sts12.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	DeptService deptService;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", deptService.list());
		return "list";
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String insert(DeptVo bean) {
		deptService.add(bean);
		System.out.println("add post...");
		return "redirect:list";
	}
}













