package com.bit.action;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;
import com.opensymphony.xwork2.Action;

public class OneDeptAction implements Action {
	int idx;
	private DeptVo bean;
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public DeptVo getBean() {
		return bean;
	}

	@Override
	public String execute() throws Exception {
		DeptDao dao=new DeptDao();
		bean=dao.selectOne(idx);
		return Action.SUCCESS;
	}

}
