package com.bit.sts05.service;

import org.springframework.ui.Model;

import com.bit.sts05.model.entity.DeptVo;

public interface DeptService {
	void selectAll(Model model);
	void selectOne(Model model,int key);
	void insertOne(DeptVo bean) throws Exception;
	void updateOne(DeptVo bean) throws Exception;
	void deleteOne(int key) throws Exception;
}
