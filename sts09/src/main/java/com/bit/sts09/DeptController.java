package com.bit.sts09;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts09.model.DeptDao;
import com.bit.sts09.model.entity.DeptVo;

/**
 * Handles requests for the application home page.
 */
@RestController
public class DeptController {
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	
	@RequestMapping(value = "/dept/", method = RequestMethod.GET)
	public List<DeptVo> home(Model model) {
		logger.info("index");
		try(
			SqlSession session=sqlSessionFactory.openSession();
		){
			DeptDao deptDao=session.getMapper(DeptDao.class);
			 return deptDao.selectAll();
		}
	}
	
}
