package com.bit.dept.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.bit.dept.model.entity.DeptVo;

public class DeptDao02Impl implements DeptDao {
	SqlMapClientTemplate template;
	
	public void setTemplate(SqlMapClientTemplate template) {
		this.template = template;
	}

	@Override
	public List<DeptVo> selectAll() throws SQLException {
		return template.queryForList("selectAll");
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		return (DeptVo) template.queryForObject("selectOne",deptno);
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		template.insert("insertOne",bean);
	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		return template.update("updateOne",bean);
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		return template.delete("deleteOne",deptno);
	}

}
