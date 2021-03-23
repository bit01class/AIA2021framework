package com.bit.dept.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.bit.dept.model.entity.DeptVo;

// testcase
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {

	@Test
	public void test01() throws SQLException{
		DeptDao dao=new DeptDao();
		Connection conn = dao.getConnection();
		assertNull(null);// 널이면 true
		assertNotNull(conn);// 널이 아니면 true
		conn.close();
		
	}
	
	@Test
	public void test02() throws SQLException {
		DeptDao dao=new DeptDao();
		assertNotNull(dao);
		assertNotNull(dao.selectAll());
		assertTrue(dao.selectAll().size()>0);
	}
	
	@Test
	public void test03() throws SQLException {
		DeptDao dao=new DeptDao();
		DeptVo target=new DeptVo(60,"test1","test2");
		assertSame(1,dao.insertOne(target));
	}
	
	@Test
	public void test04() throws SQLException {
		DeptDao dao=new DeptDao();
		DeptVo target=new DeptVo(60,"test1","test2");
		assertSame(1,dao.deleteOne(target.getDeptno()));
	}
}


















