package com.bit.i2.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.bit.i2.model.entity.DeptVo;
// 이름순서로 test보장
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {
	
//https://beomseok95.tistory.com/205	
	
	static DeptVo target;
	DeptDao dao;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		target=new DeptVo(99,"test1","test2");
	}
	@AfterClass
	public static void tearDownAfterClass() {
	}
	
	@Before
	public void setUp() throws SQLException {
		dao=new DeptDao();		
	}
	@After
	public void tearDown() {
	}
	
	@Test
	public void test01DataSource() throws SQLException {
		assertNotNull(dao.dataSource);
	}

	@Test
	public void test02SelectAll() throws SQLException {
		assertNotNull(dao.selectAll());
		assertTrue(dao.selectAll().size()>0);
	}
	
	@Test
	public void test03InsertOne() throws SQLException {
		assertSame(1,dao.insertOne(target));
	}

	@Test
	public void test04SelectOne() throws SQLException {
		assertNotNull(dao.selectOne(target.getDeptno()));
		assertEquals(target, dao.selectOne(target.getDeptno()));
	}
	
	@Test
	public void test05UpdateOne() throws SQLException {
		DeptVo bean=new DeptVo(target.getDeptno(),"edit1","edit2");
		assertSame(1,dao.updateOne(bean));
		assertEquals(bean, dao.selectOne(bean.getDeptno()));
	}
	
	@Test
	public void test06DeleteOne() throws SQLException {
		assertSame(1,dao.deleteOne(target.getDeptno()));
	}
}












