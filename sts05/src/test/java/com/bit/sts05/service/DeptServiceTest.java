package com.bit.sts05.service;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/applicationContext.xml"})
public class DeptServiceTest {
	@Inject
	DeptService deptService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSelectAll() {
		Model model=new ExtendedModelMap();
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
	public void testSelectOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertOne() {
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
