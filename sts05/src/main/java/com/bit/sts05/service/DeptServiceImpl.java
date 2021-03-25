package com.bit.sts05.service;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.sts05.model.DeptDao;
import com.bit.sts05.model.entity.DeptVo;

@Service
public class DeptServiceImpl implements DeptService {
	@Inject
	SqlSession sqlSession;

	@Override
	public void selectAll(Model model) {
		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		model.addAttribute("list", deptDao.selectAll());
	}

	@Override
	public void selectOne(Model model, int key) {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		model.addAttribute("bean", deptDao.selectOne(key));
	}

	@Override
	public void insertOne(DeptVo bean) {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		deptDao.insertOne(bean);
	}

	@Override
	public void updateOne(DeptVo bean) {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		deptDao.updateOne(bean);
	}

	@Override
	public void deleteOne(int key) {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		deptDao.deleteOne(key);
	}

}
