package com.bit.sts04.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bit.sts04.model.entity.DeptVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class DeptDaoTest {
	DeptVo target;
	@Autowired
	DeptDao deptDao;


	@Before
	public void setUp() throws Exception {
		target=new DeptVo(99,"test","test");
	}

	@After
	public void tearDown() throws Exception {
		try {
			deptDao.insertOne(target);
		}catch (Exception e) {
		}
	}
	@Test
	public void testDao() {
		assertNotNull(deptDao);
	}
	@Test
	public void testSelectAll() {
		assertNotNull(deptDao.selectAll());
		assertFalse(deptDao.selectAll().size()==0);
	}

	@Test
	public void testSelectOne() {
		assertEquals(target, deptDao.selectOne(target.getDeptno()));
	}

	@Test
	public void testInsertOne() {
		try {
			deptDao.insertOne(target);
			fail("Not yet implemented");
		}catch (Exception e) {
		}
	}

	@Test
	public void testUpdateOne() {
		assertEquals(1, deptDao.updateOne(target));
	}

	@Test
	public void testDeleteOne() {
		assertEquals(1, deptDao.deleteOne(target.getDeptno()));
	}
}
