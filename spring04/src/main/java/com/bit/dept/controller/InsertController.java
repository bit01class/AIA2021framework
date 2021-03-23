package com.bit.dept.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.dept.model.DeptDao;
import com.bit.dept.model.entity.DeptVo;

public class InsertController extends AbstractCommandController {
	DeptDao deptDao;
	
	public void setDeptDao(DeptDao deptDao) {
		this.deptDao = deptDao;
	}
	
	@Override
	protected void onBindAndValidate(HttpServletRequest request, Object command, BindException errors)
			throws Exception {
		DeptVo bean=(DeptVo) command;
		if(bean.getDeptno()==0 || bean.getDeptno()>=100) {
			ObjectError error=new ObjectError("deptno", "1~99사이를 입력하세요");
			errors.addError(error);
		}
		if(bean.getDname().isEmpty()) {
			ObjectError error=new ObjectError("dname", "부서명을 입력하세요");
			errors.addError(error);
		}
		if(bean.getLoc().isEmpty()) {
			ObjectError error=new ObjectError("loc", "지역명을 입력하세요");
			errors.addError(error);
		}
		
	}

	@Override
	protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors) throws Exception {
		ModelAndView mav=new ModelAndView();
		if(errors.hasErrors()) {
			mav.setViewName("deptadd");
			List<ObjectError> errs = errors.getAllErrors();
			for(ObjectError err:errs) {
				mav.addObject("err"+err.getObjectName(),
				err.getDefaultMessage());
			}
		}else {
			mav.setViewName("redirect:list.do");
			deptDao.insertOne((DeptVo)command);
		}
	return mav;
	}

}
