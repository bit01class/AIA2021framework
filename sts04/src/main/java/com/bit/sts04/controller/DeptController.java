package com.bit.sts04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.sts04.model.entity.DeptVo;
import com.bit.sts04.service.DeptService;

@Controller
public class DeptController {
	@Autowired
	DeptService deptService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/dept/",method = RequestMethod.GET)
	public String list(Model model) {
		deptService.list(model);
		return "list";
	}
	@RequestMapping(value = "/dept/form")
	public String addform() {
		return "add";
	}
	@RequestMapping(value = "/dept/",method = RequestMethod.POST)
	public String add(@ModelAttribute("bean") DeptVo bean) {
		if(bean.getDeptno()==0)
			return "add";
		if(bean.getDname().isEmpty())
			return "add";
		if(bean.getLoc().isEmpty())
			return "add";
			
		deptService.insert(bean);
		return "redirect:./";
	}
}












