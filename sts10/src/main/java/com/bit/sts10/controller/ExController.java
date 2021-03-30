package com.bit.sts10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExController {

	@GetMapping("/ex03")
	@ResponseBody
	public String ex03() {
		return "ex03 test page";
	}
	
	@GetMapping("/ex04")
	public void ex04() {}
}
