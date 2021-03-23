package com.bit.dept.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.bit.dept.model.entity.DeptVo;
import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class DeptDao {
	SqlMapClient sqlMapClient;
	
	public DeptDao() throws IOException {
		InputStream is=null;
		// java.io
//		is=new FileInputStream("절대경로");
		// ibatis 제공
		is=Resources.getResourceAsStream("/sqlMapConfig.xml");
		sqlMapClient=SqlMapClientBuilder.buildSqlMapClient(is);
	}
	
	public List<DeptVo> selectAll() throws SQLException {
		return sqlMapClient.queryForList("selectAll");
	}

	public void addOne(int deptno, String dname, String loc) throws SQLException {
		sqlMapClient.insert("addOne",new DeptVo(deptno,dname,loc));
	}

	public void insertOne(DeptVo bean) throws SQLException {
		sqlMapClient.insert("addOne",bean);
	}

	public DeptVo selectOne(int deptno) throws SQLException {
		return (DeptVo) sqlMapClient.queryForObject(
								"selectOne", deptno);
	}
	
	public int updateOne(DeptVo bean) throws SQLException {
		return sqlMapClient.update("updateOne", bean);
	}

	public int delOne(int deptno) throws SQLException {
		return sqlMapClient.delete("deleteOne",deptno);
		
	}
}









