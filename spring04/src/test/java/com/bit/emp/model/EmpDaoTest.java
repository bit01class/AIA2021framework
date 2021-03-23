package com.bit.emp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.emp.model.entity.EmpVo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpDaoTest {
	static EmpVo target;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		target=new EmpVo(8888,1000,4,"err");
	}

	private EmpDao empDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context;
		context=new GenericXmlApplicationContext("classpath:/applicationContext.xml");
		empDao=(EmpDao) context.getBean("empDao");
	}

	@Test
	public void test1SelectAll() {
		assertNotNull(empDao);
		assertNotNull(empDao.selectAll());
		assertFalse(empDao.selectAll().size()==0);
	}

	@Test
	public void test3SelectOne() {
		assertEquals(target, empDao.selectOne(target.getEmpno()));
	}

	@Test
	public void test2InsertOne() {
		try {
			empDao.insertOne(target);
		}catch(Exception e){
			fail("문제있음");
		}
	}

	@Test
	public void test4UpdateOne() {
		fail("Not yet implemented");
	}

	@Test
	public void test5DeleteOne() {
		fail("Not yet implemented");
	}

}
