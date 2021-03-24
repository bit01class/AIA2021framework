package com.bit.sts04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/dept/{1}",method = RequestMethod.GET)
	public String detail(@PathVariable("1") int deptno,Model model) {
		deptService.detail(model, deptno);
		return "detail";
	}
	@RequestMapping(value = "/dept/{1}",method = RequestMethod.PUT)
	public String detail(@PathVariable("1") int deptno
			,@ModelAttribute DeptVo bean) {
		deptService.update(bean);
		return "redirect:./"+deptno;
	}
	@RequestMapping(value = "/dept/{1}",method = RequestMethod.DELETE)
	public String detail(@PathVariable("1") int deptno) {
		deptService.delete(deptno);
		return "redirect:./";
	}
}












