package com.bit.sts01.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.util.Bit;

// POJO
@Controller
public class Ex01Controller{

	@RequestMapping("/ex01.do")
	public String ex01(Model model) throws Exception {
		model.addAttribute("msg", "ABCDEFG");
		return "ex01";
	}
	
	@RequestMapping("/ex02.do")
	public String ex02() {
		return "ex02";
	}
	
	@RequestMapping("/ex03.do")
	public void ex03() {}
	
	@RequestMapping("/test/ex04")
	public String ex04() {
		return "ex04";
	}
}















