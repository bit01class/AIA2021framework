package com.bit.sts11.model;

import java.util.List;

import com.bit.sts11.model.entity.DeptVo;

public interface DeptDao {

	List<DeptVo> selectAll();

}