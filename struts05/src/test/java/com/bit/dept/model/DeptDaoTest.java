package com.bit.dept.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeptDaoTest{
	DeptDao dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao=new DeptDao();
	}

	@Test
	public void testDeptDao() {
		assertNotNull(dao);
		assertNotNull(dao.sqlMapClient);
	}

	@Test
	public void testSelectAll() {
		fail("Not yet implemented");
	}

}
