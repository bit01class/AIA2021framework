package com.bit.dept.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.dept.model.entity.DeptVo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {
	DeptDao deptDao;
	static DeptVo target;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		target=new DeptVo(99,"test1","test2");
	}

	@Before
	public void setUp() throws Exception {
		ApplicationContext context;
		context=new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		deptDao=(DeptDao) context.getBean("proxy");
	}

	@Test
	public void test1SelectAll() {
		assertNotNull(deptDao);
		try {
			assertNotNull(deptDao.selectAll());
			assertFalse(deptDao.selectAll().size()==0);
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void test3SelectOne() {
		try {
			assertEquals(target, deptDao.selectOne(target.getDeptno()));
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void test2InsertOne() {
		try {
			deptDao.insertOne(target);
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void test4UpdateOne() {
		target.setDname("edit1");
		target.setLoc("edit2");
		try {
			assertSame(1, deptDao.updateOne(target));
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void test5DeleteOne() {
		try {
			assertSame(1, deptDao.deleteOne(target.getDeptno()));
		} catch (SQLException e) {
			fail("Not yet implemented");
		}
	}

}
