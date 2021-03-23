package com.bit.i2.action;

import java.util.List;

import com.bit.i2.model.DeptDao;
import com.bit.i2.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;

public class IndexAction implements Action {

	private List<DeptVo> list;
	
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
