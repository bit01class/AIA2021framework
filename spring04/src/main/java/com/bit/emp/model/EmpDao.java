package com.bit.emp.model;

import java.util.List;

import com.bit.emp.model.entity.EmpVo;

public interface EmpDao {

	List<EmpVo> selectAll();
	EmpVo selectOne(int empno);
	void insertOne(EmpVo bean);
	int updateOne(EmpVo bean);
	int deleteOne(int empno);
}
