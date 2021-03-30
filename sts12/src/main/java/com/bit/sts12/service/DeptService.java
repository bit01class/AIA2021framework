package com.bit.sts12.service;

import java.util.List;

import com.bit.sts12.model.entity.DeptVo;

public interface DeptService {

	List<DeptVo> list();

	DeptVo bean(int deptno);

	void add(DeptVo bean);

	int edit(DeptVo bean);

	int delete(int deptno);

}