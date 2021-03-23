package com.bit.sts02.model;

import java.util.List;

import com.bit.sts02.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> selectAll();
	
	DeptVo selectOne(int deptno);
	
	void insertOne(DeptVo bean);
	
	int updateOne(DeptVo bean);
	
	int deleteOne(int deptno);
}
