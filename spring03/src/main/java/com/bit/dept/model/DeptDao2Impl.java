package com.bit.dept.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.bit.dept.model.entity.DeptVo;

public class DeptDao2Impl extends JdbcDaoSupport implements DeptDao {

	@Override
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept order by deptno";
		RowMapper rowMapper=new RowMapper<DeptVo>() {

			@Override
			public DeptVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
			}
		};
		Object[] args= {};
		return getJdbcTemplate().query(sql, rowMapper, args);
	}

	@Override
	public DeptVo selectOne(int deptno) throws SQLException {
		return null;
	}

	@Override
	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		getJdbcTemplate().update(sql
				,new Object[] {bean.getDeptno()
						,bean.getDname(),bean.getLoc()});
	}

	@Override
	public void insertTwo(DeptVo bean) throws SQLException {

	}

	@Override
	public int updateOne(DeptVo bean) throws SQLException {
		return 0;
	}

	@Override
	public int deleteOne(int deptno) throws SQLException {
		return 0;
	}

}
