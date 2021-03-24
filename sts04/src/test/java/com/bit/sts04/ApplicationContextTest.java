package com.bit.sts04;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationContextTest {
	Logger log=LoggerFactory.getLogger(getClass());
	ApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context=new GenericXmlApplicationContext("classpath:/applicationContext.xml");
	}

	@Test
	public void testDataSource() throws BeansException, SQLException {
		assertNotNull(context.getBean(DataSource.class));
		log.debug(context.getBean(DataSource.class).getConnection().toString());
	}

}










