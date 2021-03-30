package com.bit.sts12.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.sts12.model.DeptDao;
import com.bit.sts12.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	@Autowired
	SqlSessionFactory factory;
	
	@Override
	public List<DeptVo> list() {
		try(
			SqlSession session=factory.openSession();
		){
			DeptDao deptDao=session.getMapper(DeptDao.class);
			return deptDao.selectAll();
		}
	}
	
	@Override
	public DeptVo bean(int deptno) {
		try(
			SqlSession session=factory.openSession();
		){
			DeptDao deptDao=session.getMapper(DeptDao.class);
		return deptDao.selectOne(deptno);
		}
	}
	
	@Override
	public void add(DeptVo bean) {
		try(
			SqlSession session=factory.openSession();
		){
			session.getMapper(DeptDao.class).insertOne(bean);
		}
	}
	
	@Override
	public int edit(DeptVo bean) {
		try(
			SqlSession session=factory.openSession();
		) {
			return session.getMapper(DeptDao.class)
						.updateOne(bean);
		}
	}
	
	@Override
	public int delete(int deptno) {
		try(
			SqlSession session=factory.openSession();
		){
			return session.getMapper(DeptDao.class)
						.deleteOne(deptno);
		}
	}
}












