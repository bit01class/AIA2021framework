package com.bit.dept.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.bit.dept.model.entity.DeptVo;

public class DeptDao3Impl implements DeptDao {

	JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept order by deptno desc";
		RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		jdbcTemplate.update(sql, bean.getDeptno()
						,bean.getDname(),bean.getLoc());
	}

	@Override
	public void insertTwo(DeptVo bean) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
