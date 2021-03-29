package com.bit.sts09.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.bit.sts09.model.entity.DeptVo;

public interface DeptDao {

	@Select("select * from dept")
	List<DeptVo> selectAll();
}
