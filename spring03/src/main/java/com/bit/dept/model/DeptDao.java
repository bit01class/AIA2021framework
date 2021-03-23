package com.bit.dept.model;

import java.sql.SQLException;
import java.util.List;

import com.bit.dept.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> selectAll() throws SQLException;
	DeptVo selectOne(int deptno) throws SQLException;
	void insertOne(DeptVo bean) throws SQLException;
	void insertTwo(DeptVo bean) throws SQLException;
	int updateOne(DeptVo bean) throws SQLException;
	int deleteOne(int deptno) throws SQLException;
}
