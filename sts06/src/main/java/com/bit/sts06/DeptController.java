package com.bit.sts06;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts06.model.DeptDao;
import com.bit.sts06.model.entity.DeptVo;

@RestController
public class DeptController {
	@Inject
	SqlSessionFactory sqlSessionFactory;
	
	@GetMapping(value = "/dept")
	public List<DeptVo> list() {
		
		List<DeptVo> list=null;
		try(
			SqlSession session=sqlSessionFactory.openSession();
				){
			list=session.getMapper(DeptDao.class).selectAll();
		}
		return list;
	}
	
	@PostMapping("/dept")
	public ResponseEntity add(DeptVo bean) {
		try(
				SqlSession session=sqlSessionFactory.openSession();
				){
			session.getMapper(DeptDao.class).insertOne(bean);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/dept/{deptno}")
	public DeptVo detail(@PathVariable int deptno) {
		try(
			SqlSession session=sqlSessionFactory.openSession();	
				){			
			return session.getMapper(DeptDao.class).selectOne(deptno);
		}
	}
	
	@PutMapping("/dept/{deptno}")
	public void update(@PathVariable int deptno
						,@RequestBody DeptVo bean) {
		System.out.println(bean);
	}
}











