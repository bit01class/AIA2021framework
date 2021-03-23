package com.bit.model;

import java.util.List;

import com.bit.model.entity.DeptVo;

public interface DeptDao {
	List<DeptVo> selectAll();
	void insertOne(DeptVo bean);
	DeptVo selectOne(int deptno);
	int updateOne(DeptVo bean);
	int deleteOne(int deptno);
}
