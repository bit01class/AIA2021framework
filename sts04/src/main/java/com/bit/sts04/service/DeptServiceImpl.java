package com.bit.sts04.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts04.model.DeptDao;
import com.bit.sts04.model.entity.DeptVo;

@Service	
public class DeptServiceImpl implements DeptService {
	@Autowired
	DeptDao deptDao;
	
	@Override
	public void list(Model model) {
		model.addAttribute("list", deptDao.selectAll());
	}

	@Override
	public void insert(DeptVo bean) {
		deptDao.insertOne(bean);
	}

	@Override
	public void detail(Model model, int deptno) {
		model.addAttribute("bean", deptDao.selectOne(deptno));
	}

	@Override
	public void update(DeptVo bean) {
		deptDao.updateOne(bean);
	}

	@Override
	public void delete(int deptno) {
		deptDao.deleteOne(deptno);
	}
}
