package com.bit.dept.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

public class DeptAction implements ModelDriven<DeptVo>{
	Logger log=Logger.getLogger(this.getClass());
	List<DeptVo> list;
	DeptDao dao;
	DeptVo bean=new DeptVo();
	
	public DeptAction() throws IOException {
		dao=new DeptDao();
	}
	@Override
	public DeptVo getModel() {
		return bean;
	}
	public DeptVo getBean() {
		return bean;
	}
	public List<DeptVo> getList() {
		return list;
	}
	
	public String addOne() throws Exception {
		dao.insertOne(bean);
		return Action.SUCCESS;
	}

	public String execute() throws Exception {
		list=dao.selectAll();
		return Action.SUCCESS;
	}
	
	public String selectOne() throws Exception{
		bean=dao.selectOne(bean.getDeptno());
		log.info(bean);
		return Action.SUCCESS;
	}
	
	public String editOne() throws SQLException {
		dao.updateOne(bean);
		return Action.SUCCESS;
	}
	
	public String deleteOne() throws SQLException {
		dao.delOne(bean.getDeptno());
		return Action.SUCCESS;
	}

}










