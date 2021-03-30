package com.bit.sts12.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bit.sts12.model.DeptDao;
import com.bit.sts12.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	SqlSessionTemplate template;
	@Autowired
	SqlSessionFactory factory;
	
	@Override
	public List<DeptVo> list() {
		return template.selectList(
				DeptDao.class.getTypeName()+".selectAll");
	}
	
	@Override
	public DeptVo bean(int deptno) {
		return template.selectOne(
				DeptDao.class.getTypeName()+".selectOne");
	}
	
	@Override
	@Transactional
	public void add(DeptVo bean) {
		System.out.println("add service...");
		template.insert(DeptDao.class.getTypeName()+".insertOne",bean);
//		try(
//			SqlSession session=factory.openSession();
//		){
//			session.getMapper(DeptDao.class).insertOne(bean);
//		}
	}
	
	@Override
	public int edit(DeptVo bean) {
		return template.update(DeptDao.class.getTypeName()+".updateOne");
	}
	
	@Override
	public int delete(int deptno) {
		return template.delete(DeptDao.class.getTypeName()+".deleteOne");
	}
}












