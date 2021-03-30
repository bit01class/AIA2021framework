package com.bit.sts11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.bit.sts11.model.DeptDao;
import com.bit.sts11.model.entity.DeptVo;

@SpringBootApplication
public class Sts11Application extends SpringBootServletInitializer{
	@Autowired
	DeptDao deptDao;

	public static void main(String[] args) {
		SpringApplication.run(Sts11Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Sts11Application.class);
	}
}
