package com.bit.sts12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts12.model.entity.DeptVo;
import com.bit.sts12.service.DeptService;

@RestController
public class DeptApiController {
	@Autowired
	DeptService deptService;

	@GetMapping("/dept/")
	public List<DeptVo> list(){
		return deptService.list();
	}
}
