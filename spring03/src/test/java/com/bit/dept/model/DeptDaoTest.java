package com.bit.dept.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class DeptDaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	private DeptDao deptDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context=null;
		context=new FileSystemXmlApplicationContext("/src/main/webapp/WEB-INF/root-context.xml");
		assertNotNull(context);
		deptDao=(DeptDao) context.getBean("deptDao");
		
	}

	@Test
	public void testSelectAll() throws SQLException {
		assertNotNull(deptDao);
		assertTrue(deptDao.selectAll().size()>0);
	}

	@Test
	public void testSelectOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertTwo() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteOne() {
		fail("Not yet implemented");
	}

}
