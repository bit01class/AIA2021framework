package com.bit.sts01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class Ex02Controller {

	@RequestMapping("ex05")
	public String ex01() {
		return "ex05";
	}
	
	@RequestMapping(value="ex06", method = RequestMethod.POST)
	public void ex02(){
		
	}
}
