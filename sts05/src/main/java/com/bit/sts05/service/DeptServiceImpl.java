package com.bit.sts05.service;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.bit.sts05.model.DeptDao;
import com.bit.sts05.model.entity.DeptVo;


//https://www.egovframe.go.kr/wiki/doku.php?id=egovframework:rte:psl:transaction:declarative_transaction_management
@Transactional(isolation = Isolation.DEFAULT
,propagation = Propagation.REQUIRED)
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
	public void insertOne(DeptVo bean) throws Exception {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		deptDao.insertOne(bean);
	}

	@Override
	public void updateOne(DeptVo bean) throws Exception {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		if(deptDao.updateOne(bean)==0) throw new Exception();
	}

	@Override
	public void deleteOne(int key) throws Exception {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		if(deptDao.deleteOne(key)==0) throw new Exception();
	}

}
