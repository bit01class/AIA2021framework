package com.bit.sts02.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.sts02.model.DeptDao;
import com.bit.sts02.model.entity.DeptVo;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	DeptDao deptDao;
	
	@RequestMapping("list")
	public void list(Model model) {
		model.addAttribute("list", deptDao.selectAll());
	}
	
	@RequestMapping(value="add",method = RequestMethod.GET)
	public void add() {}
	
//	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(HttpServletRequest req) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		deptDao.insertOne(new DeptVo(
				Integer.parseInt(req.getParameter("deptno"))
				,req.getParameter("dname")
				,req.getParameter("loc")
				));
		return "redirect:list";
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String add(@RequestParam("deptno")int deptno
			,@RequestParam("dname") String dname
			,@RequestParam("loc") String loc) throws UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
		deptDao.insertOne(new DeptVo(deptno,dname,loc));
		return "redirect:list";
	}
	
	@RequestMapping(value = "dept",method = RequestMethod.GET)
	public String one(@RequestParam("idx") int deptno,Model model) {
		model.addAttribute("bean", deptDao.selectOne(deptno));
		return "dept/dept";
	}
	
	@RequestMapping(value = "dept",method = RequestMethod.POST)
	public String edit(@ModelAttribute DeptVo bean) throws UnsupportedEncodingException {
		
		deptDao.updateOne(bean);
		return "redirect:dept?idx="+bean.getDeptno();
	}
	
	@RequestMapping(value = "dept/{deptno}", method = RequestMethod.POST)
	public String delete(@PathVariable("deptno") int deptno) {
		deptDao.deleteOne(deptno);
		return "redirect:../list";
	}
}











