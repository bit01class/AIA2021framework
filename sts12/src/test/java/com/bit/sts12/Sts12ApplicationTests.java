package com.bit.sts12;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bit.sts12.service.DeptService;


@SpringBootTest
class Sts12ApplicationTests {
	@Autowired
	DeptService deptService;

	@Test
	void contextLoads() {
		assertNotNull(deptService.list());
		assertFalse(deptService.list().size()==0);
	}

}
