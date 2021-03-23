package com.bit.action;

import java.util.List;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;

public class DeptAction implements Action {
	List<DeptVo> list;
	
	public List<DeptVo> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		DeptDao dao=new DeptDao();
		list=dao.selectAll();
		
		return Action.SUCCESS;
	}

}
