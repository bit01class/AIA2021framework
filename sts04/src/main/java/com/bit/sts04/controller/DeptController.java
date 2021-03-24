package com.bit.sts04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeptController {

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
