package com.bit.sts12.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bit.sts12.model.entity.DeptVo;

public interface DeptDao {

	@Select("select * from dept order by deptno")
	List<DeptVo> selectAll();
	
	@Select("select * from dept where deptno=#{key}")
	DeptVo selectOne(int key);
	
	@Insert("insert into dept values (#{deptno},#{dname},#{loc})")
	void insertOne(DeptVo bean);
	
	@Update("update dept set dname=#{dname},loc=#{loc} where deptno=#{deptno}")
	int updateOne(DeptVo bean);
	@Delete("delete from dept where deptno=#{key}")
	int deleteOne(int key);
}
