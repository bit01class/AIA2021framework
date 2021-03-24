package com.bit.sts04.service;

import org.springframework.ui.Model;

import com.bit.sts04.model.entity.DeptVo;

public interface DeptService {

	void list(Model model);
	void insert(DeptVo bean);
}