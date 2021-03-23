package com.bit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.mariadb.jdbc.MariaDbDataSource;

import com.bit.framework.RowMapper;
import com.bit.framework.core.JdbcTemplate;
import com.bit.model.entity.DeptVo;

public class DeptDao {
	DataSource dataSource;
	
	public DeptDao() throws SQLException {
		MariaDbDataSource source=null;
		source=new MariaDbDataSource();
		source.setUrl("jdbc:mysql://localhost:3306/xe");
		source.setUser("scott");
		source.setPassword("tiger");
		dataSource=source;
	}
	
	public List<DeptVo> selectAll() throws SQLException {
		String sql="select * from dept order by deptno";
		JdbcTemplate<DeptVo> template=new JdbcTemplate<DeptVo>();
		
		RowMapper<DeptVo> rowMapper=new RowMapper<DeptVo>(){

			@Override
			public DeptVo mapRow(ResultSet rs) throws SQLException{
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
			}
		};
		template.setDataSource(dataSource);
		return template.queryForList(sql,rowMapper);
	}

	public Object selectOne(int param) throws SQLException {
		String sql="select * from dept where deptno=?";
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		// 1.8 람다식
		// 인터페이스(추상메서드 한하나)
		RowMapper rowMapper= (ResultSet rs) -> {
				return new DeptVo(
						rs.getInt("deptno")
						,rs.getString("dname")
						,rs.getString("loc")
						);
		};
		return template.queryForOne(sql,rowMapper,param);
	}

	public int updateOne(DeptVo bean) throws SQLException {
		String sql="update dept set dname=?,loc=? where deptno=?";
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(dataSource);
		return template.executeUpdate(sql,bean.getDname(),bean.getLoc(),bean.getDeptno());
	}

	public void insertOne(DeptVo bean) throws SQLException {
		String sql="insert into dept values (?,?,?)";
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(dataSource);
		template.executeUpdate(sql, new Object[]{bean.getDeptno(),bean.getDname(),bean.getLoc()});
		
	}
	
	public int deleteOne(int param) throws SQLException {
		String sql="delete from dept where deptno=?";
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(dataSource);
		return template.executeUpdate(sql, param);
	}
}















