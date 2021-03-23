package com.bit.dept.model;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

import com.bit.dept.model.entity.DeptVo;

import oracle.jdbc.pool.OracleDataSource;

public class DeptDaoTest {
	//tdd

	public static void main(String[] args) throws Exception {
		DeptDao dao=new DeptDao();
		dao.log.setLevel(Level.WARNING);
		List<DeptVo> list = dao.getList();
		notNull(list);
		//same(7,list.size());
		checkTrue(list.size()>0);
	}
	
	public static void checkTrue(boolean boo) throws Exception {
		if(!boo) throw new Exception("false입니다");
	}
	
	public static void same(int a, int b) throws Exception {
		if(a!=b) throw new Exception("예상치보다 "
						+(a-b)+"만큼 차이납니다");
	}
	
	public static void notNull(Object obj) throws Exception {
		if(obj==null) throw new Exception("널");
	}

}
