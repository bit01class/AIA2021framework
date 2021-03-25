package com.bit.sts05.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.bit.sts05.model.entity.DeptVo;

import lombok.extern.log4j.Log4j;

@Log4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/applicationContext.xml"})
public class DeptServiceTest {
	@Inject
	DeptService deptService;
	DeptVo target;
	Model model;

	@Before
	public void setUp() throws Exception {
		target=new DeptVo(100,"test1","test2");
		model=new ExtendedModelMap();
	}

	@Test
	public void test1SelectAll() {
		try {
		deptService.selectAll(model);
		Map<String, Object> map = model.asMap();
		Set<Entry<String, Object>> set = map.entrySet();
		for (Entry<String, Object> entry : set) {
			log.debug(entry);
		}
		assertFalse(map.isEmpty());
		}catch (Exception e) {
			fail("Not yet implemented");
		}
	}

	@Test
	public void test4SelectOne() {
		deptService.selectOne(model, target.getDeptno());
		assertTrue(model.containsAttribute("bean"));
	}

	@Test
	public void test2InsertOne() {
		try {
		deptService.insertOne(target);
		}catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test3UpdateOne() {
		try {
		deptService.updateOne(target);
		}catch (Exception e) {
			fail();
		}
	}

	@Test
	public void test5DeleteOne() {
		try {
		deptService.deleteOne(target.getDeptno());
		}catch (Exception e) {
			fail();
		}
	}

}






