package com.bit.dept.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import com.bit.dept.model.entity.DeptVo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDaoTest {
	DeptDao deptDao;
	private static int cnt;
	static DeptVo target;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		target=new DeptVo(99,"test1","test2");
	}

	@Before
	public void setUp() throws Exception {
		ApplicationContext context=null;
//		context=new ClassPathXmlApplicationContext("/applicationContext.xml");
//		context=new FileSystemXmlApplicationContext("/src/main/resources/applicationContext.xml");
//		context=new FileSystemXmlApplicationContext("classpath:/applicationContext.xml");
		context=new GenericXmlApplicationContext("classpath:/applicationContext.xml");
//		context=new GenericXmlApplicationContext("/WEB-INF/spring/servlet-context.xml");
		deptDao=(DeptDao) context.getBean("deptDao");
	}

	@Test
	public void test1SelectAll() throws SQLException {
		assertNotNull(deptDao);
		assertNotNull(deptDao.selectAll());
		cnt=deptDao.selectAll().size();
		assertTrue(cnt>0);
	}

	@Test
	public void test2InsertOne() {
		try {
			deptDao.insertOne(target);
		} catch (SQLException e) {
			fail("insert fail..");
		}
	}

	@Test
	public void test3SelectOne() throws SQLException {
		assertEquals(target, deptDao.selectOne(target.getDeptno()));
	}

	@Test
	public void test4UpdateOne() throws SQLException {
		target.setDname("edit1");
		target.setLoc("edit2");
		assertSame(1, deptDao.updateOne(target));//==
		assertEquals(target, deptDao.selectOne(target.getDeptno()));
	}

	@Test
	public void test5DeleteOne() throws SQLException {
		assertNotSame(cnt,deptDao.selectAll().size());
		assertSame(1,deptDao.deleteOne(target.getDeptno()));
		assertSame(cnt,deptDao.selectAll().size());
	}

}
